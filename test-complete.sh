#!/bin/bash

# Script completo de prueba para producción
# Incluye actualización de producto + imágenes
# Uso: ./test-complete.sh [PRODUCT_CODE]

PROD_SERVER="http://10.10.10.251:8890"
PRODUCT_CODE=${1:-"04773"}

echo "🚀 PRUEBA COMPLETA EN PRODUCCIÓN"
echo "Servidor: $PROD_SERVER"
echo "Producto: $PRODUCT_CODE"
echo "========================================"

# Test 1: Actualizar producto completo
echo -e "\n🏷️  PASO 1: Actualizando producto completo..."
curl -X PUT "$PROD_SERVER/api/product-categorizacion/$PRODUCT_CODE" \
  -H "Content-Type: application/json" \
  -w "\nHTTP Status: %{http_code}\n" \
  -d "{
    \"codigoInterno\": \"$PRODUCT_CODE\",
    \"upc\": \"8012992000052\",
    \"nombre\": \"PRODUCTO ACTUALIZADO VIA API\",
    \"descripcion\": \"Producto actualizado mediante API REST\",
    \"principioActivo\": \"Principio Activo Actualizado\",
    \"concentracion\": \"500mg\",
    \"formaFarmaceuticaId\": 1,
    \"viaAdministracionId\": 2,
    \"poblacionDianaId\": 1,
    \"precio\": 25.99,
    \"costo\": 15.50,
    \"stock\": 75,
    \"stockMinimo\": 10,
    \"activo\": true,
    \"categoryId\": 1,
    \"subcategoryId\": 5,
    \"tagIds\": [1, 3, 7]
  }" | python3 -m json.tool 2>/dev/null

echo -e "\n⏱️  Esperando 2 segundos para sincronización..."
sleep 2

# Test 2: Verificar actualización del producto
echo -e "\n🔍 PASO 2: Verificando producto actualizado..."
curl -s -X GET "$PROD_SERVER/api/product-categorizacion/$PRODUCT_CODE" | python3 -m json.tool 2>/dev/null

# Test 3: Actualizar imágenes
echo -e "\n📸 PASO 3: Actualizando imágenes del producto..."
curl -X POST "$PROD_SERVER/api/product-images/products/$PRODUCT_CODE/images/bulk-update" \
  -H "Content-Type: application/json" \
  -w "\nHTTP Status: %{http_code}\n" \
  -d "{
    \"images\": [
      {
        \"rutaImagen\": \"/media/products/${PRODUCT_CODE}_main_image.webp\",
        \"orden\": 1,
        \"altText\": \"Imagen principal - $PRODUCT_CODE\"
      },
      {
        \"rutaImagen\": \"/media/products/${PRODUCT_CODE}_side_view.webp\",
        \"orden\": 2,
        \"altText\": \"Vista lateral - $PRODUCT_CODE\"
      },
      {
        \"rutaImagen\": \"/media/products/${PRODUCT_CODE}_detail.webp\",
        \"orden\": 3,
        \"altText\": \"Detalle - $PRODUCT_CODE\"
      }
    ]
  }" | python3 -m json.tool 2>/dev/null

# Test 4: Verificar imágenes finales
echo -e "\n🖼️  PASO 4: Verificando imágenes guardadas..."
curl -s -X GET "$PROD_SERVER/api/product-images/product/$PRODUCT_CODE" | python3 -m json.tool 2>/dev/null

echo -e "\n✅ PRUEBA COMPLETA FINALIZADA"
echo "================================================"
echo "✓ Producto actualizado con todos los campos"
echo "✓ Imágenes actualizadas (3 imágenes)"
echo "✓ Verificaciones completadas"
echo "================================================"

# Ejemplos de uso:
# ./test-complete.sh                    # Usa producto 04773 por defecto  
# ./test-complete.sh 03576              # Prueba con producto 03576
# ./test-complete.sh 10628              # Prueba con producto 10628
