import { onMounted } from 'vue'
import { apiProduct } from '../Services/api/products/apiProduct'
const { getAllProducts } = apiProduct()
import { ref } from 'vue'
const productos = ref([])
export function verProductos() {
  function retornarProductos() {
    onMounted(async () => {
      productos.value = await getAllProducts()
      console.log(productos.value)
    })
    return {
      productos
    }
  }
  return {
    retornarProductos
  }
}
