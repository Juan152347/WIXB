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
    const content = await response.json()
    console.log(content)
  }
  async function log(body) {
    const url = 'http://localhost:8080/Users/Login/'
    const config = {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body:body
    }

    const response = await fetch(url, config)
    const content = await response.json()
    console.log(content)
  }
  return {
    RegisterUser,
    log
  }
}
