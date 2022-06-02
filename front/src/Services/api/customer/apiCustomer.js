export function apiCustomer() {
  async function RegisterUser(body) {
    const url = 'http://localhost:8080/Users/Customer/Create/'
    const config = {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: body
    }

    const response = await fetch(url, config)
    const content = await response
    if (!response.ok) {
      alert('Hubo un error en el registro')
    } else alert("Registro Exitoso")
    console.log(content)
  }
  async function log(body) {
    const url = 'http://localhost:8080/Users/Login/'
    const config = {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: body
    }

    const response = await fetch(url, config)
    const content = await response.json()
    if (!response.ok) {
      alert('Hubo un error de credenciales')
    } else alert("Login Exitoso")
    console.log(content)
  }
  return {
    RegisterUser,
    log
  }
}
