import { apiBarber } from '../Services/BarberList/barberList'
import { onMounted } from 'vue'
import { ref } from 'vue'
const { getBarber } = apiBarber()
const BarberS = ref([])
export function verBarberos() {
  function retornarBarberos() {
    onMounted(async () => {
      BarberS.value = await getBarber()
      console.log(liBarber.value)
    })
    return {
      BarberS
    }
  }

  return {
    retornarBarberos
  }
}
