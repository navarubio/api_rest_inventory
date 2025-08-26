# Script de prueba para el endpoint de bulk update de imágenes
# Simula el comportamiento de la app cargando imágenes

Write-Host "=== PRUEBA DE BULK UPDATE DE IMAGENES ==="

# Datos de prueba que simula lo que viene de la app
$testData = @{
    images = @(
        @{
            rutaImagen = "/media/products/10628_505b2b2e-2116-444c-a75f-41fef249b25d.webp"
            orden = 1
            altText = "Imagen principal del producto 10628"
        },
        @{
            rutaImagen = "/media/products/10628_a1b2c3d4-5678-90ef-ghij-klmnopqrstuv.webp"
            orden = 2
            altText = "Vista lateral del producto 10628"
        },
        @{
            rutaImagen = "/media/products/10628_12345678-abcd-efgh-ijkl-mnopqrstuvwx.webp"
            orden = 3
            altText = "Detalle del producto 10628"
        }
    )
}

$jsonBody = $testData | ConvertTo-Json -Depth 3

Write-Host "1. Verificando imágenes existentes del producto 10628..."
try {
    $existingImages = Invoke-RestMethod -Uri "http://localhost:8080/api/product-images/product/10628" -Method GET -ContentType "application/json"
    Write-Host "Imágenes actuales: $($existingImages.Count)"
    $existingImages | ForEach-Object { Write-Host "  - $($_.rutaImagen) (orden: $($_.orden))" }
} catch {
    Write-Host "Error obteniendo imágenes existentes: $($_.Exception.Message)"
}

Write-Host "`n2. Ejecutando bulk update de imágenes..."
try {
    $result = Invoke-RestMethod -Uri "http://localhost:8080/api/product-images/products/10628/images/bulk-update" -Method POST -ContentType "application/json" -Body $jsonBody
    Write-Host "Bulk update exitoso! Imágenes guardadas: $($result.Count)"
    $result | ForEach-Object { Write-Host "  - $($_.rutaImagen) (orden: $($_.orden), id: $($_.id))" }
} catch {
    Write-Host "Error en bulk update: $($_.Exception.Message)"
    Write-Host "Detalle del error: $($_.ErrorDetails.Message)"
}

Write-Host "`n3. Verificando imágenes después del update..."
try {
    $updatedImages = Invoke-RestMethod -Uri "http://localhost:8080/api/product-images/product/10628" -Method GET -ContentType "application/json"
    Write-Host "Imágenes después del update: $($updatedImages.Count)"
    $updatedImages | ForEach-Object { Write-Host "  - $($_.rutaImagen) (orden: $($_.orden), id: $($_.id))" }
} catch {
    Write-Host "Error verificando imágenes actualizadas: $($_.Exception.Message)"
}

Write-Host "`n=== FIN DE LA PRUEBA ==="
