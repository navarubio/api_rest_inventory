# Test simple con curl para el producto 03576
# Este es el formato exacto que mencionaste en el contexto

echo "=== Test de Bulk Update de Imágenes ==="
echo "Producto: 03576"
echo "Imágenes actuales:"
curl.exe -s -X GET http://localhost:8080/api/product-images/product/03576

echo -e "\n\nEjecutando bulk update..."
curl.exe -X POST http://localhost:8080/api/product-images/products/03576/images/bulk-update \
  -H "Content-Type: application/json" \
  -d @test-product-03576-images.json

echo -e "\n\nVerificando resultado:"
curl.exe -s -X GET http://localhost:8080/api/product-images/product/03576

echo -e "\n=== Fin del test ==="
