<template>
  <div  class="wrapper-list">
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
    <button @click="Create()">registrarse</button>
  </div>
</template>

<script>
import { ref } from 'vue'
import { registroUsuario} from '../Uses/registro'

export default {
  name: 'App',
  setup() {
    const {RegisterUserCreate} = registroUsuario()
    const customer = ref({
      name: '',
      cellphone: '',
      password: ''
    })
    function Create(){
      RegisterUserCreate(customer.value.cellphone,customer.value.name,customer.value.password)
    }
   
    return {
      customer,
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
  background-color: #cd9f6e;
}
</style>
