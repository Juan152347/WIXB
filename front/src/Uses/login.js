import { apiCustomer } from '../Services/api/customer/apiCustomer'
const { log } = apiCustomer()
export function loginUsuario(){
    async function logCreate(nombre,pass) {
        const body = JSON.stringify({
          name: nombre,
          Pasword: pass
        })
        await log(body)
    }
    return {
        logCreate
    }
}