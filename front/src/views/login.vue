<template>
  <div class="wrapper-list">
    <div class="wrapper-input">
      <label>Nombre:</label>
      <input type="text" class="form" v-model="nombre" />
    </div>
    <div class="wrapper-input">
      <label>Contraseña:</label>
      <input type="text" class="form" v-model="pass" />
    </div>
    <button @click="Create">Ingresar</button>
  </div>
</template>
<script>
import { ref } from 'vue'
import {loginUsuario} from '../Uses/login'
export default {
  name: 'App',
  setup() {
    const nombre = ref('')
    const pass = ref('')
    const {logCreate} = loginUsuario()
    async function Create() {
      logCreate(nombre.value,pass.value)
    }
    return {
      nombre,
      pass,
      Create

    }
  }
}
</script>
<style>
.form {
  margin-top: 2rem;
}
.wrapper-list {
  list-style: none;
  padding: 2rem;
}
</style>
