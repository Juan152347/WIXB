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
    <button @click="RegisterUserCreate()">registrarse</button>
  </div>
</template>

<script>
import { ref } from 'vue'
import { v4 as uuidv4 } from 'uuid'
import { apiCustomer } from '../Services/api/customer/apiCustomer'

export default {
  name: 'App',
  setup() {
    const { RegisterUser } = apiCustomer()
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
    async function RegisterUserCreate() {
      const body = JSON.stringify({
        userId: uuidv4(),
        phone: customer.value.cellphone,
        username: customer.value.name,
        password: customer.value.password
      })
      await RegisterUser(body)
    }
    return {
      counter,
      addCounter,
      customer,
      show,
      RegisterUserCreate
    }
  }
}
</script>

<style>
.form {
  margin-top: 2rem;
}
</style>
