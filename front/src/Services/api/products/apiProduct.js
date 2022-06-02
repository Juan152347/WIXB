export function apiProduct() {
  async function getAllProducts() {
    const url = 'http://localhost:8080/Product/All'
    const config = {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      }
    }

    const response = await fetch(url, config)
    const content = await response.json()
    console.log(content)
    return {
      content
    }
  }
  return {
    getAllProducts
  }
}
