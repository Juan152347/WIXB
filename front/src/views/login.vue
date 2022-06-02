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
    <button @click="log">Ingresar</button>
  </div>
</template>
<script>
import { ref } from 'vue'
export default {
  name: 'App',
  setup() {
    const nombre = ref('')
    const pass = ref('')

    async function log() {
      console.log(nombre.value)
      console.log(pass.value)
      const url = 'http://localhost:8080/Users/Login/'
      const config = {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
          name: nombre.value,
          Pasword: pass.value
        })
      }

      const response = await fetch(url, config)
      const content = await response.json()
      console.log(content)
    }
    return {
      nombre,
      pass,
      log
    }
  }
}
</script>
<style>
.form {
  margin-top: 2rem;
}
</style>
