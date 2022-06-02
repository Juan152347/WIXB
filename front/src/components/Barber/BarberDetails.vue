<template>
  <p>Nombre Barebero : {{ name }}</p>
  <p>Celular Barebero : {{ phone }}</p>
  <button>Reservar</button>
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
    },
}
</script>

<style scoped lang="scss"></style>
