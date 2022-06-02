<template>
  <ul class="wrapper-list">
    <li v-for="(producto, index) in productos.content" :key="index">
      <div class="wrapper-Barber">
        <p>{{ producto.decription }}</p>
      </div>
    </li>
  </ul>
</template>
<script>

import {verProductos} from '../Uses/products'
export default {
  name: 'App',
  setup() {
    const { retornarProductos} = verProductos()
    const {productos} = retornarProductos()

    return {
      productos
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
