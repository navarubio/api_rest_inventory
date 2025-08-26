/**
 * Cliente API para manejo de imágenes de productos
 * Servidor de producción: 10.10.10.251:8890
 */

class ProductImageAPI {
  constructor(baseUrl = 'http://10.10.10.251:8890') {
    this.baseUrl = baseUrl;
  }

  /**
   * Obtiene todas las imágenes de un producto
   * @param {string} codigoInterno - Código interno del producto
   * @returns {Promise<Array>} Lista de imágenes
   */
  async getProductImages(codigoInterno) {
    try {
      const response = await fetch(`${this.baseUrl}/api/product-images/product/${codigoInterno}`);
      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }
      return await response.json();
    } catch (error) {
      console.error('Error obteniendo imágenes del producto:', error);
      throw error;
    }
  }

  /**
   * Actualiza masivamente las imágenes de un producto
   * @param {string} codigoInterno - Código interno del producto
   * @param {Array} images - Array de objetos con {rutaImagen, orden, altText}
   * @returns {Promise<Array>} Lista de imágenes guardadas
   */
  async bulkUpdateProductImages(codigoInterno, images) {
    try {
      const response = await fetch(
        `${this.baseUrl}/api/product-images/products/${codigoInterno}/images/bulk-update`,
        {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify({ images })
        }
      );

      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }

      return await response.json();
    } catch (error) {
      console.error('Error en bulk update de imágenes:', error);
      throw error;
    }
  }

  /**
   * Helper: Convierte archivos subidos a formato para la API
   * @param {string} codigoInterno - Código interno del producto
   * @param {Array} uploadedFiles - Array de archivos subidos con UUID
   * @returns {Array} Array formateado para la API
   */
  formatUploadedImages(codigoInterno, uploadedFiles) {
    return uploadedFiles.map((file, index) => ({
      rutaImagen: `/media/products/${codigoInterno}_${file.uuid}.webp`,
      orden: index + 1,
      altText: file.altText || `Imagen ${index + 1} del producto ${codigoInterno}`
    }));
  }

  /**
   * Flujo completo: Sube archivos y actualiza la base de datos
   * @param {string} codigoInterno - Código interno del producto
   * @param {FileList} files - Archivos a subir
   * @param {Function} uploadCallback - Función que sube los archivos y retorna los UUIDs
   * @returns {Promise<Array>} Imágenes guardadas en la base de datos
   */
  async uploadAndUpdateImages(codigoInterno, files, uploadCallback) {
    try {
      console.log(`Subiendo ${files.length} imágenes para el producto ${codigoInterno}...`);
      
      // 1. Subir archivos al servidor (implementar según tu lógica de upload)
      const uploadedFiles = await uploadCallback(files);
      
      // 2. Formatear para la API
      const formattedImages = this.formatUploadedImages(codigoInterno, uploadedFiles);
      
      // 3. Actualizar base de datos
      console.log('Actualizando base de datos...');
      const savedImages = await this.bulkUpdateProductImages(codigoInterno, formattedImages);
      
      console.log(`✅ Proceso completo! ${savedImages.length} imágenes guardadas.`);
      return savedImages;
      
    } catch (error) {
      console.error('Error en el flujo completo de imágenes:', error);
      throw error;
    }
  }
}

// Ejemplos de uso:

// 1. Instanciar el cliente
const imageAPI = new ProductImageAPI();

// 2. Obtener imágenes existentes
async function loadProductImages(productCode) {
  try {
    const images = await imageAPI.getProductImages(productCode);
    console.log('Imágenes del producto:', images);
    return images;
  } catch (error) {
    console.error('Error cargando imágenes:', error);
  }
}

// 3. Actualizar imágenes manualmente
async function updateImages(productCode) {
  const newImages = [
    {
      rutaImagen: `/media/products/${productCode}_505b2b2e-2116-444c-a75f-41fef249b25d.webp`,
      orden: 1,
      altText: 'Imagen principal del producto'
    },
    {
      rutaImagen: `/media/products/${productCode}_a1b2c3d4-5678-90ef-ghij-klmnopqrstuv.webp`,
      orden: 2,
      altText: 'Vista lateral del producto'
    }
  ];

  try {
    const result = await imageAPI.bulkUpdateProductImages(productCode, newImages);
    console.log('Imágenes actualizadas:', result);
    return result;
  } catch (error) {
    console.error('Error actualizando imágenes:', error);
  }
}

// 4. Uso en React/Vue/Angular component
/*
class ProductImageManager {
  async handleImageUpload(productCode, fileInputElement) {
    const files = fileInputElement.files;
    
    // Mock upload function - implementar según tu servidor
    const mockUpload = async (files) => {
      return Array.from(files).map((file, index) => ({
        uuid: this.generateUUID(),
        originalName: file.name,
        altText: `Imagen ${index + 1}`
      }));
    };

    try {
      const savedImages = await imageAPI.uploadAndUpdateImages(
        productCode, 
        files, 
        mockUpload
      );
      
      // Actualizar UI con las imágenes guardadas
      this.displayImages(savedImages);
      
    } catch (error) {
      this.showError('Error procesando imágenes: ' + error.message);
    }
  }

  generateUUID() {
    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
      const r = Math.random() * 16 | 0;
      const v = c == 'x' ? r : (r & 0x3 | 0x8);
      return v.toString(16);
    });
  }
}
*/

// Exportar para uso en modules
// export default ProductImageAPI;
