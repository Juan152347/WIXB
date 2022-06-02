<template>
  <p>Descripcion producto : {{ decription }}</p>
  <p>Stock : {{ quantity }}</p>
  <p>Precio producto : {{ price }}</p>
  <p>Valoracion del producto : {{ rating }}</p>
  <button>Ordenar</button>
</template>

<script lang="js">

export default {
    name: "ProductDetail",
    props:{
        decription:{
            type: String,
            default: ""
        },
        quantity:{
            type: Number,
            default: 0
        },
        price:{
            type: Number,
            default: 0
        },
        rating:{
            type: Number,
            default: 0
        },
    },
    setup(){
        return {}
    },
}
</script>

<style scoped lang="scss"></style>
