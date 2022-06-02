<template>
  <div>
    <div class="wrapper-input">
      <label>Nombre:</label>
      <input type="text" class="form" v-model="nombre" />
    </div>
    <div class="wrapper-input">
      <label>Contraseña:</label>
      <input type="text" class="form" v-model="pass" />
    </div>
    <button @click="logCreate">Ingresar</button>
  </div>
</template>
<script>
import { ref } from 'vue'
import { apiCustomer } from '../Services/api/customer/apiCustomer'
export default {
  name: 'App',
  setup() {
    const nombre = ref('')
    const pass = ref('')
    const { log } = apiCustomer()

    async function logCreate() {
      const body = JSON.stringify({
        name:nombre.value,
        Pasword:pass.value
      })
      await log(body)
    }
    return {
      nombre,
      pass,
      logCreate

    }
  }
}
</script>
<style>
.form {
  margin-top: 2rem;
}
</style>
