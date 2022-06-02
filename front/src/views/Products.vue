<template>
  <ul class="wrapper-list">
    <li
      v-for="(producto, index) in productos.content"
      :key="index"
      @click="Description(producto)"
    >
      <div class="wrapper-Barber">
        <p>{{ producto.decription }}</p>
      </div>
    </li>
  </ul>
  <div v-if="hayProduct">
    <ProductDetail
      :decription="actualproduct.decription"
      :quantity="actualproduct.quantity"
      :price="actualproduct.price"
      :rating="actualproduct.rating"
    />
  </div>
</template>
<script>
import { verProductos } from '../Uses/products'
import { computed, ref } from 'vue'
import ProductDetail from '../components/Products/ProductDetail.vue'
export default {
  name: 'App',
  components: {
    ProductDetail
  },
  setup() {
    const actualproduct = ref(null)
    const { retornarProductos } = verProductos()
    const { productos } = retornarProductos()

    function Description(producto) {
      console.log(actualproduct)
      actualproduct.value = producto
    }

    const hayProduct = computed(() => {
      return actualproduct.value != null
    })

    return {
      productos,
      ProductDetail,
      Description,
      hayProduct,
      actualproduct
    }
  }
}
</script>
<style scoped lang="css">
.wrapper-list {
  list-style: none;
  padding: 2rem;
  background-color: #cd9f6e;
}
.wrapper-Barber {
  width: 30%;
  border-radius: 0.8rem;
  background-color: #9b6b37;
  padding: 0.3rem;
  margin-bottom: 1rem;
  cursor: pointer;
}
</style>
