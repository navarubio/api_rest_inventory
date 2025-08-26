#!/bin/bash

# Script de prueba rápida para el servidor de producción
# Uso: ./quick-test.sh [PRODUCT_CODE]

PROD_SERVER="http://10.10.10.251:8890"
PRODUCT_CODE=${1:-"03576"}

echo "🚀 PRUEBA RÁPIDA EN PRODUCCIÓN"
echo "Servidor: $PROD_SERVER"
echo "Producto: $PRODUCT_CODE"
echo "=================================="

# Test 1: Leer imágenes actuales
echo -e "\n📖 PASO 1: Imágenes actuales"
curl -s -X GET "$PROD_SERVER/api/product-images/product/$PRODUCT_CODE" | python3 -m json.tool 2>/dev/null || echo "[]"

# Test 2: Bulk update
echo -e "\n✍️  PASO 2: Bulk update"
curl -X POST "$PROD_SERVER/api/product-images/products/$PRODUCT_CODE/images/bulk-update" \
  -H "Content-Type: application/json" \
  -w "\nHTTP Status: %{http_code}\n" \
  -d "{
    \"images\": [
      {
        \"rutaImagen\": \"/media/products/${PRODUCT_CODE}_159150028.webp\",
        \"orden\": 1,
        \"altText\": \"Imagen principal producto $PRODUCT_CODE\"
      },
      {
        \"rutaImagen\": \"/media/products/${PRODUCT_CODE}_960014590.webp\",
        \"orden\": 2,
        \"altText\": \"Imagen secundaria producto $PRODUCT_CODE\"
      }
    ]
  }" | python3 -m json.tool 2>/dev/null

# Test 3: Verificar resultado
echo -e "\n🔍 PASO 3: Verificación final"
curl -s -X GET "$PROD_SERVER/api/product-images/product/$PRODUCT_CODE" | python3 -m json.tool 2>/dev/null || echo "Error en la verificación"

echo -e "\n✅ Prueba completada"

# Ejemplos de uso:
# ./quick-test.sh                 # Usa producto 03576 por defecto  
# ./quick-test.sh 10628          # Prueba con producto 10628
# ./quick-test.sh 04773          # Prueba con producto 04773
