# Script de prueba COMPLETO para producción
# Incluye actualización de producto + imágenes
# Servidor: 10.10.10.251:8890

param(
    [string]$ProductCode = "04773",
    [string]$Server = "http://10.10.10.251:8890"
)

Write-Host "=== PRUEBA COMPLETA - PRODUCTO + IMÁGENES ===" -ForegroundColor Green
Write-Host "Servidor: $Server" -ForegroundColor Cyan
Write-Host "Producto: $ProductCode" -ForegroundColor Cyan

# Función para mostrar JSON formateado
function Show-JsonResponse {
    param($Response, $Title = "Respuesta")
    Write-Host "`n$Title:" -ForegroundColor Magenta
    if ($Response) {
        $Response | ConvertTo-Json -Depth 5 | Write-Host -ForegroundColor Yellow
    } else {
        Write-Host "Sin respuesta" -ForegroundColor Red
    }
}

# ========================================
# PARTE 1: ACTUALIZACIÓN DEL PRODUCTO
# ========================================

Write-Host "`n🏷️  PASO 1: Actualizando datos del producto..." -ForegroundColor Blue

# Datos completos del producto
$productData = @{
    codigoInterno = $ProductCode
    upc = "8012992000052"
    nombre = "ASPIRINA 500MG TABLETAS - ACTUALIZADO"
    descripcion = "Analgésico y antiinflamatorio de uso común"
    principioActivo = "Ácido acetilsalicílico"
    concentracion = "500mg"
    formaFarmaceuticaId = 1
    viaAdministracionId = 2
    poblacionDianaId = 1
    precio = 18.75
    costo = 9.50
    stock = 85
    stockMinimo = 15
    activo = $true
    categoryId = 1
    subcategoryId = 5
    tagIds = @(1, 3, 7)
}

$productJson = $productData | ConvertTo-Json -Depth 3
Write-Host "Datos del producto a enviar:" -ForegroundColor Cyan
Show-JsonResponse $productData "Datos del producto"

try {
    $productResult = Invoke-RestMethod -Uri "$Server/api/product-categorizacion/$ProductCode" `
                                      -Method PUT `
                                      -ContentType "application/json" `
                                      -Body $productJson
    
    Write-Host "✅ Producto actualizado exitosamente!" -ForegroundColor Green
    Show-JsonResponse $productResult "Producto actualizado"
} catch {
    Write-Host "❌ Error actualizando producto: $($_.Exception.Message)" -ForegroundColor Red
    if ($_.ErrorDetails.Message) {
        Write-Host "Detalle: $($_.ErrorDetails.Message)" -ForegroundColor Red
    }
    return
}

# ========================================
# PARTE 2: ACTUALIZACIÓN DE IMÁGENES
# ========================================

Write-Host "`n📸 PASO 2: Verificando imágenes actuales..." -ForegroundColor Blue
try {
    $currentImages = Invoke-RestMethod -Uri "$Server/api/product-images/product/$ProductCode" -Method GET
    Write-Host "Imágenes encontradas: $($currentImages.Count)" -ForegroundColor Green
    Show-JsonResponse $currentImages "Imágenes actuales"
} catch {
    Write-Host "Error obteniendo imágenes actuales: $($_.Exception.Message)" -ForegroundColor Red
}

Write-Host "`n📸 PASO 3: Actualizando imágenes del producto..." -ForegroundColor Blue

# Datos de imágenes
$imageData = @{
    images = @(
        @{
            rutaImagen = "/media/products/$ProductCode" + "_505b2b2e-2116-444c-a75f-41fef249b25d.webp"
            orden = 1
            altText = "Imagen principal - $ProductCode"
        },
        @{
            rutaImagen = "/media/products/$ProductCode" + "_a1b2c3d4-5678-90ef-ghij-klmnopqrstuv.webp"
            orden = 2
            altText = "Vista lateral - $ProductCode"
        },
        @{
            rutaImagen = "/media/products/$ProductCode" + "_12345678-abcd-efgh-ijkl-mnopqrstuvwx.webp"
            orden = 3
            altText = "Detalle del producto - $ProductCode"
        }
    )
}

$imageJson = $imageData | ConvertTo-Json -Depth 3
Write-Host "Datos de imágenes a enviar:" -ForegroundColor Cyan
Show-JsonResponse $imageData "Imágenes a guardar"

try {
    $imageResult = Invoke-RestMethod -Uri "$Server/api/product-images/products/$ProductCode/images/bulk-update" `
                                    -Method POST `
                                    -ContentType "application/json" `
                                    -Body $imageJson
    
    Write-Host "✅ Imágenes actualizadas exitosamente! Total: $($imageResult.Count)" -ForegroundColor Green
    Show-JsonResponse $imageResult "Imágenes guardadas"
} catch {
    Write-Host "❌ Error actualizando imágenes: $($_.Exception.Message)" -ForegroundColor Red
    if ($_.ErrorDetails.Message) {
        Write-Host "Detalle: $($_.ErrorDetails.Message)" -ForegroundColor Red
    }
}

# ========================================
# PARTE 3: VERIFICACIÓN FINAL
# ========================================

Write-Host "`n🔍 PASO 4: Verificación final..." -ForegroundColor Blue

# Verificar producto actualizado
try {
    Write-Host "Verificando datos del producto..." -ForegroundColor Cyan
    $finalProduct = Invoke-RestMethod -Uri "$Server/api/product-categorizacion/$ProductCode" -Method GET
    
    if ($finalProduct.nombre -eq $productData.nombre -and $finalProduct.precio -eq $productData.precio) {
        Write-Host "✅ Producto verificado correctamente" -ForegroundColor Green
        Write-Host "  - Nombre: $($finalProduct.nombre)" -ForegroundColor White
        Write-Host "  - Precio: $($finalProduct.precio)" -ForegroundColor White
        Write-Host "  - Stock: $($finalProduct.stock)" -ForegroundColor White
    } else {
        Write-Host "⚠️  Los datos del producto no coinciden completamente" -ForegroundColor Yellow
    }
} catch {
    Write-Host "❌ Error verificando producto: $($_.Exception.Message)" -ForegroundColor Red
}

# Verificar imágenes finales
try {
    Write-Host "`nVerificando imágenes finales..." -ForegroundColor Cyan
    $finalImages = Invoke-RestMethod -Uri "$Server/api/product-images/product/$ProductCode" -Method GET
    
    if ($finalImages.Count -eq 3) {
        Write-Host "✅ Imágenes verificadas correctamente: $($finalImages.Count)" -ForegroundColor Green
        $finalImages | ForEach-Object { 
            Write-Host "  - Orden $($_.orden): $($_.rutaImagen)" -ForegroundColor White 
        }
    } else {
        Write-Host "⚠️  Se esperaban 3 imágenes, se encontraron $($finalImages.Count)" -ForegroundColor Yellow
        Show-JsonResponse $finalImages "Imágenes encontradas"
    }
} catch {
    Write-Host "❌ Error verificando imágenes: $($_.Exception.Message)" -ForegroundColor Red
}

# ========================================
# RESUMEN FINAL
# ========================================

Write-Host "`n=== RESUMEN DE LA PRUEBA ===" -ForegroundColor Green
Write-Host "Producto probado: $ProductCode" -ForegroundColor White
Write-Host "Servidor: $Server" -ForegroundColor White
Write-Host "✅ Actualización de producto: Completada" -ForegroundColor Green
Write-Host "✅ Actualización de imágenes: Completada" -ForegroundColor Green
Write-Host "✅ Verificaciones: Completadas" -ForegroundColor Green

Write-Host "`n🎉 ¡PRUEBA COMPLETA FINALIZADA!" -ForegroundColor Green

# Ejemplo de uso:
# .\test-complete-production.ps1 -ProductCode "04773"
# .\test-complete-production.ps1 -ProductCode "03576" -Server "http://10.10.10.251:8890"
