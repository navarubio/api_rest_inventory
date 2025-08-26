# DOCUMENTACIÓN API - ENDPOINTS DE PRODUCTOS EN PRODUCCIÓN
## Servidor de Producción: 10.10.10.251:8890

## 🏷️ ENDPOINT DE ACTUALIZACIÓN COMPLETA DE PRODUCTO

```http
PUT http://10.10.10.251:8890/api/product-categorizacion/{codigoInterno}
```

### Características:
- ✅ **Actualización completa**: Todos los campos del producto
- ✅ **Actualización parcial**: Solo campos enviados (no nulls)
- ✅ **Transaccional**: Garantiza integridad de datos
- ✅ **Headers requeridos**: `Content-Type: application/json`

### Formato del JSON completo:
```json
{
  "codigoInterno": "04773",
  "upc": "8012992000052",
  "nombre": "ASPIRINA 500MG TABLETAS",
  "descripcion": "Analgésico y antiinflamatorio",
  "principioActivo": "Ácido acetilsalicílico",
  "concentracion": "500mg",
  "formaFarmaceuticaId": 1,
  "viaAdministracionId": 2,
  "poblacionDianaId": 1,
  "precio": 15.50,
  "costo": 8.75,
  "stock": 100,
  "stockMinimo": 20,
  "activo": true,
  "categoryId": 1,
  "subcategoryId": 5,
  "tagIds": [1, 3, 7]
}
```

---

## 📸 ENDPOINTS DE IMÁGENES

### 📖 ENDPOINT DE LECTURA (Ya funcional)
```http
GET http://10.10.10.251:8890/api/product-images/product/{codigoInterno}
```

**Ejemplo:**
```bash
curl -X GET "http://10.10.10.251:8890/api/product-images/product/03576"
```

**Respuesta:**
```json
[
  {
    "id": 7,
    "codigoInternoProducto": "03576",
    "rutaImagen": "/media/products/03576_159150028.webp",
    "orden": 1,
    "altText": "Imagen principal producto 03576"
  },
  {
    "id": 8,
    "codigoInternoProducto": "03576",
    "rutaImagen": "/media/products/03576_960014590.webp",
    "orden": 2,
    "altText": "Imagen secundaria producto 03576"
  }
]
```

---

### ✍️ ENDPOINT DE ESCRITURA MASIVA DE IMÁGENES (Nuevo)
```http
POST http://10.10.10.251:8890/api/product-images/products/{codigoInterno}/images/bulk-update
```

#### Características:
- ✅ **Transaccional**: Borra todas las imágenes existentes y guarda las nuevas
- ✅ **Escribe en**: `fdw_vegfarm.product_images_write`
- ✅ **Lee desde**: `fdw_vegfarm.product_images_read` (para respuesta)
- ✅ **Headers requeridos**: `Content-Type: application/json`

#### Formato del JSON:
```json
{
  "images": [
    {
      "rutaImagen": "/media/products/{codigoInterno}_{uuid}.webp",
      "orden": 1,
      "altText": "Descripción de la imagen"
    },
    {
      "rutaImagen": "/media/products/{codigoInterno}_{uuid}.webp",
      "orden": 2,
      "altText": "Descripción de la imagen"
    }
  ]
}
```

---

## 🧪 EJEMPLOS DE USO EN PRODUCCIÓN

### 🏷️ ACTUALIZACIÓN COMPLETA DE PRODUCTO

#### 1. Con cURL - Actualización completa:
```bash
# Actualizar producto completo con todos los campos
curl -X PUT "http://10.10.10.251:8890/api/product-categorizacion/04773" \
  -H "Content-Type: application/json" \
  -d '{
    "codigoInterno": "04773",
    "upc": "8012992000052",
    "nombre": "ASPIRINA 500MG TABLETAS",
    "descripcion": "Analgésico y antiinflamatorio",
    "principioActivo": "Ácido acetilsalicílico",
    "concentracion": "500mg",
    "formaFarmaceuticaId": 1,
    "viaAdministracionId": 2,
    "poblacionDianaId": 1,
    "precio": 15.50,
    "costo": 8.75,
    "stock": 100,
    "stockMinimo": 20,
    "activo": true,
    "categoryId": 1,
    "subcategoryId": 5,
    "tagIds": [1, 3, 7]
  }'
```

#### 2. Con cURL - Actualización parcial:
```bash
# Actualizar solo precio y stock
curl -X PUT "http://10.10.10.251:8890/api/product-categorizacion/04773" \
  -H "Content-Type: application/json" \
  -d '{
    "precio": 18.50,
    "stock": 150
  }'
```

#### 3. Con PowerShell - Producto completo:
```powershell
$productData = @{
    codigoInterno = "04773"
    upc = "8012992000052"
    nombre = "ASPIRINA 500MG TABLETAS"
    descripcion = "Analgésico y antiinflamatorio"
    principioActivo = "Ácido acetilsalicílico"
    concentracion = "500mg"
    formaFarmaceuticaId = 1
    viaAdministracionId = 2
    poblacionDianaId = 1
    precio = 15.50
    costo = 8.75
    stock = 100
    stockMinimo = 20
    activo = $true
    categoryId = 1
    subcategoryId = 5
    tagIds = @(1, 3, 7)
} | ConvertTo-Json -Depth 3

Invoke-RestMethod -Uri "http://10.10.10.251:8890/api/product-categorizacion/04773" `
                  -Method PUT `
                  -ContentType "application/json" `
                  -Body $productData
```

### 📸 ACTUALIZACIÓN DE IMÁGENES

#### 1. Con cURL (Linux/Windows con Git Bash):
```bash
# Actualizar imágenes del producto 03576
curl -X POST "http://10.10.10.251:8890/api/product-images/products/03576/images/bulk-update" \
  -H "Content-Type: application/json" \
  -d '{
    "images": [
      {
        "rutaImagen": "/media/products/03576_159150028.webp",
        "orden": 1,
        "altText": "Imagen principal producto 03576"
      },
      {
        "rutaImagen": "/media/products/03576_960014590.webp",
        "orden": 2,
        "altText": "Imagen secundaria producto 03576"
      }
    ]
  }'
```

#### 2. Con PowerShell (Windows):
```powershell
$body = @{
    images = @(
        @{
            rutaImagen = "/media/products/03576_159150028.webp"
            orden = 1
            altText = "Imagen principal producto 03576"
        },
        @{
            rutaImagen = "/media/products/03576_960014590.webp"
            orden = 2
            altText = "Imagen secundaria producto 03576"
        }
    )
} | ConvertTo-Json -Depth 3

Invoke-RestMethod -Uri "http://10.10.10.251:8890/api/product-images/products/03576/images/bulk-update" `
                  -Method POST `
                  -ContentType "application/json" `
                  -Body $body
```

#### 3. Con JavaScript/Fetch (Frontend):
```javascript
const updateProductImages = async (codigoInterno, images) => {
  const response = await fetch(`http://10.10.10.251:8890/api/product-images/products/${codigoInterno}/images/bulk-update`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify({
      images: images.map((img, index) => ({
        rutaImagen: `/media/products/${codigoInterno}_${img.uuid}.webp`,
        orden: index + 1,
        altText: img.altText || `Imagen ${index + 1} del producto`
      }))
    })
  });
  
  return await response.json();
};

// Ejemplo de uso:
const images = [
  { uuid: "505b2b2e-2116-444c-a75f-41fef249b25d", altText: "Imagen principal" },
  { uuid: "a1b2c3d4-5678-90ef-ghij-klmnopqrstuv", altText: "Vista lateral" }
];

updateProductImages("10628", images)
  .then(result => console.log('Imágenes actualizadas:', result));
```

#### 4. Con Python (requests):
```python
import requests
import json

def update_product_images(codigo_interno, images):
    url = f"http://10.10.10.251:8890/api/product-images/products/{codigo_interno}/images/bulk-update"
    
    data = {
        "images": [
            {
                "rutaImagen": f"/media/products/{codigo_interno}_{img['uuid']}.webp",
                "orden": idx + 1,
                "altText": img.get('altText', f'Imagen {idx + 1} del producto')
            }
            for idx, img in enumerate(images)
        ]
    }
    
    response = requests.post(
        url,
        headers={'Content-Type': 'application/json'},
        json=data
    )
    
    return response.json()

# Ejemplo de uso:
images = [
    {"uuid": "505b2b2e-2116-444c-a75f-41fef249b25d", "altText": "Imagen principal"},
    {"uuid": "a1b2c3d4-5678-90ef-ghij-klmnopqrstuv", "altText": "Vista lateral"}
]

result = update_product_images("10628", images)
print("Imágenes actualizadas:", result)
```

---

### 🔄 FLUJO COMPLETO RECOMENDADO

1. **La app sube las imágenes al servidor** → Genera archivos con UUID
   ```
   /media/products/10628_505b2b2e-2116-444c-a75f-41fef249b25d.webp
   ```

2. **La app llama al endpoint de bulk update** → Actualiza la base de datos
   ```json
   POST /api/product-images/products/10628/images/bulk-update
   {
     "images": [
       {
         "rutaImagen": "/media/products/10628_505b2b2e-2116-444c-a75f-41fef249b25d.webp",
         "orden": 1,
         "altText": "Imagen principal"
       }
     ]
   }
   ```

3. **El sistema confirma el guardado** → Retorna las imágenes desde la tabla de lectura
   ```json
   [
     {
       "id": 9,
       "codigoInternoProducto": "10628",
       "rutaImagen": "/media/products/10628_505b2b2e-2116-444c-a75f-41fef249b25d.webp",
       "orden": 1,
       "altText": "Imagen principal"
     }
   ]
   ```

---

### ⚠️ CONSIDERACIONES IMPORTANTES

- **Transaccional**: El endpoint elimina TODAS las imágenes existentes del producto antes de guardar las nuevas
- **Orden**: El campo `orden` determina el orden de visualización de las imágenes
- **Paths**: Usar rutas relativas que coincidan con la estructura del servidor `/media/products/`
- **Alt Text**: Opcional pero recomendado para accesibilidad
- **UUID**: Los nombres de archivo deben incluir UUID únicos para evitar colisiones

---

### 🧪 SCRIPT DE PRUEBA PARA PRODUCCIÓN

```bash
#!/bin/bash
# test-production.sh

PROD_SERVER="http://10.10.10.251:8890"
PRODUCT_CODE="03576"

echo "=== PRUEBA DE PRODUCCIÓN ==="
echo "Servidor: $PROD_SERVER"
echo "Producto: $PRODUCT_CODE"

echo -e "\n1. Verificando imágenes actuales..."
curl -s -X GET "$PROD_SERVER/api/product-images/product/$PRODUCT_CODE" | python -m json.tool

echo -e "\n2. Actualizando imágenes..."
curl -X POST "$PROD_SERVER/api/product-images/products/$PRODUCT_CODE/images/bulk-update" \
  -H "Content-Type: application/json" \
  -d '{
    "images": [
      {
        "rutaImagen": "/media/products/03576_159150028.webp",
        "orden": 1,
        "altText": "Imagen principal producto 03576"
      },
      {
        "rutaImagen": "/media/products/03576_960014590.webp",
        "orden": 2,
        "altText": "Imagen secundaria producto 03576"
      }
    ]
  }' | python -m json.tool

echo -e "\n3. Verificando resultado final..."
curl -s -X GET "$PROD_SERVER/api/product-images/product/$PRODUCT_CODE" | python -m json.tool

echo -e "\n=== FIN DE LA PRUEBA ==="
```
