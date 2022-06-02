<template>
  <div>
    <div class="wrapper-input">
      <label>Nombre:</label>
      <input type="text" class="form" v-model="customer.name" />
    </div>
    <div class="wrapper-input">
      <label>Celular:</label>
      <input type="text" class="form" v-model="customer.cellphone" />
    </div>
    <div class="wrapper-input">
      <label>Contraseña:</label>
      <input type="text" class="form" v-model="customer.password" />
    </div>
    <button @click="RegisterUser()">registrarse</button>
  </div>
</template>

<script>
import { ref } from 'vue'
import { v4 as uuidv4 } from 'uuid'

export default {
  name: 'App',
  setup() {
    const counter = ref(0)
    const customer = ref({
      name: '',
      cellphone: '',
      password: ''
    })

    function addCounter() {
      counter.value--
    }
    function show() {
      console.log(customer.value.name)
      console.log(customer.value.cellphone)
      console.log(customer.value.password)
    }
    async function RegisterUser() {
      console.log(customer.value.cellphone)
      const url = 'http://localhost:8080/Users/Customer/Create/'
      const config = {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
          userId: uuidv4(),
          phone: customer.value.cellphone,
          username: customer.value.name,
          password: customer.value.password
        })
      }
    
      const response = await fetch(url, config)
      const content = await response.json()
      console.log(content)
    }
    return {
      counter,
      addCounter,
      customer,
      show,
      RegisterUser
    }
  }
}
</script>

<style>
.form {
  margin-top: 2rem;
}
</style>
