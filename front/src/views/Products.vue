<template>
  <button @click="show">Listar productos</button>
  <li v-for="(producto, index) in productos.content" :key="index">
    <div>
      <p>{{ producto.decription }}</p>
    </div>
  </li>
</template>
<script>
import { onMounted } from 'vue'
import { ref } from 'vue'
import { apiProduct } from '../Services/api/products/apiProduct'
export default {
  name: 'App',
  setup() {
    const { getAllProducts } = apiProduct()
    const productos = ref([])

    onMounted(async () => {
      productos.value = await getAllProducts()
      console.log(productos.value)
    })

    function show() {
      console.log(productos.value)
    }
    return {
      show,
      productos,
    }
  }
}
</script>
<style></style>
