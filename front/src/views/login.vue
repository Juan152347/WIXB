<template>
  <div>
    <div class="wrapper-input">
      <label>Nombre:</label>
      <input type="text" class="form" v-model="customer.name" />
    </div>
    <div class="wrapper-input">
      <label>Contraseña:</label>
      <input type="text" class="form" v-model="customer.password" />
    </div>
    <button @click="">Ingresar</button>
  </div>
</template>
<script>
    import { ref } from 'vue'
    export default {
    name: 'App',
    setup() {
        const nombre = ref('')
        const pass = ref('')

            async function log(){
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

    }
    }
</script>
<style>
.form {
  margin-top: 2rem;
}
</style>