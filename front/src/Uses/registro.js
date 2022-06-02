import { v4 as uuidv4 } from 'uuid'
import { apiCustomer } from '../Services/api/customer/apiCustomer'
const { RegisterUser } = apiCustomer()

export function registroUsuario() {
  async function RegisterUserCreate(cellphone, name, password) {
    const body = JSON.stringify({
      userId: uuidv4(),
      phone: cellphone,
      username: name,
      password: password
    })
    await RegisterUser(body)
  }
  return {
    RegisterUserCreate
  }
}
