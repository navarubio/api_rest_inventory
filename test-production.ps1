# Script de prueba para el servidor de producción
# Servidor: 10.10.10.251:8890

param(
    [string]$ProductCode = "03576",
    [string]$Server = "http://10.10.10.251:8890"
)

Write-Host "=== PRUEBA API IMÁGENES EN PRODUCCIÓN ===" -ForegroundColor Green
Write-Host "Servidor: $Server" -ForegroundColor Cyan
Write-Host "Producto: $ProductCode" -ForegroundColor Cyan

# Función para mostrar JSON formateado
function Show-JsonResponse {
    param($Response)
    if ($Response) {
        $Response | ConvertTo-Json -Depth 5 | Write-Host -ForegroundColor Yellow
    } else {
        Write-Host "Sin respuesta" -ForegroundColor Red
    }
}

# 1. Verificar imágenes actuales
Write-Host "`n1. 📖 Verificando imágenes actuales..." -ForegroundColor Blue
try {
    $currentImages = Invoke-RestMethod -Uri "$Server/api/product-images/product/$ProductCode" -Method GET
    Write-Host "Imágenes encontradas: $($currentImages.Count)" -ForegroundColor Green
    Show-JsonResponse $currentImages
} catch {
    Write-Host "Error obteniendo imágenes actuales: $($_.Exception.Message)" -ForegroundColor Red
}

# 2. Datos de prueba para el bulk update
$testData = @{
    images = @(
        @{
            rutaImagen = "/media/products/$ProductCode" + "_159150028.webp"
            orden = 1
            altText = "Imagen principal producto $ProductCode"
        },
        @{
            rutaImagen = "/media/products/$ProductCode" + "_960014590.webp"
            orden = 2
            altText = "Imagen secundaria producto $ProductCode"
        }
    )
}

$jsonBody = $testData | ConvertTo-Json -Depth 3

Write-Host "`n2. ✍️ Ejecutando bulk update..." -ForegroundColor Blue
Write-Host "Datos a enviar:" -ForegroundColor Magenta
Show-JsonResponse $testData

try {
    $updateResult = Invoke-RestMethod -Uri "$Server/api/product-images/products/$ProductCode/images/bulk-update" `
                                     -Method POST `
                                     -ContentType "application/json" `
                                     -Body $jsonBody
    
    Write-Host "✅ Bulk update exitoso! Imágenes guardadas: $($updateResult.Count)" -ForegroundColor Green
    Show-JsonResponse $updateResult
} catch {
    Write-Host "❌ Error en bulk update: $($_.Exception.Message)" -ForegroundColor Red
    if ($_.ErrorDetails.Message) {
        Write-Host "Detalle: $($_.ErrorDetails.Message)" -ForegroundColor Red
    }
}

# 3. Verificar resultado final
Write-Host "`n3. 🔍 Verificando resultado final..." -ForegroundColor Blue
try {
    $finalImages = Invoke-RestMethod -Uri "$Server/api/product-images/product/$ProductCode" -Method GET
    Write-Host "Imágenes finales: $($finalImages.Count)" -ForegroundColor Green
    Show-JsonResponse $finalImages
    
    # Verificar que las imágenes se guardaron correctamente
    if ($finalImages.Count -eq 2) {
        Write-Host "✅ TEST EXITOSO: Se guardaron correctamente las 2 imágenes" -ForegroundColor Green
    } else {
        Write-Host "⚠️  ADVERTENCIA: Se esperaban 2 imágenes, se encontraron $($finalImages.Count)" -ForegroundColor Yellow
    }
} catch {
    Write-Host "❌ Error verificando resultado final: $($_.Exception.Message)" -ForegroundColor Red
}

Write-Host "`n=== FIN DE LA PRUEBA ===" -ForegroundColor Green

# Ejemplo de uso desde línea de comandos:
# .\test-production.ps1 -ProductCode "10628"
# .\test-production.ps1 -ProductCode "03576" -Server "http://10.10.10.251:8890"
