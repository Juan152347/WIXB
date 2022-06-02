<template>
  <p>Nombre Barebero : {{ name }}</p>
  <p>Celular Barebero : {{ phone }}</p>
</template>

<script lang="js">

export default {
    name: "BarberDetail",
    props:{
        name:{
            type: String,
            default: ""
        },
        phone:{
            type: String,
            default: ""
        },
    },
    setup(){
        return {}
    }
}
</script>

<style></style>
