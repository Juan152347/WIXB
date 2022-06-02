
import { v4 as uuidv4 } from 'uuid'
export function apiCustomer(){

    async function RegisterUser(body) {
        console.log(customer.value.cellphone)
        const url = 'http://localhost:8080/Users/Customer/Create/'
        const config = {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: body
        }
      
        const response = await fetch(url, config)
        const content = await response.json()
        console.log(content)
    }
     async function log(nombre, pass){
        const url = 'http://localhost:8080/Users/Login/'
        const config = {
            method: 'POST',
            headers: {
            'Content-Type': 'application/json'
            },
            body: JSON.stringify({
              name:nombre,
              Pasword:pass
            })
        }
        
        const response = await fetch(url, config)
        const content = await response.json()
        console.log(content)
    }
}