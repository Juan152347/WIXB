export function apiBarber() {
  async function getBarber() {
    const url = 'http://localhost:8080/Users/Barbers/All'
    const config = {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      }
    }

    const response = await fetch(url, config)

    if (!response.ok) {
      console.error('Hubo un error Trayendo los Barberos')
    } else console.log(response)

    const content = await response.json()

    return content
  }

  return {
    getBarber
  }
}
