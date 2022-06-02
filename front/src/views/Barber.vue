<template>
  <ul class="wrapper-list">
    <li
      v-for="(barber, index) in liBarber"
      :key="index"
      @click="Description(barber)"
    >
      <div class="wrapper-Barber">
        <p>{{ barber.name }}</p>
      </div>
    </li>
  </ul>
</template>

<script>
import { toggleSidebar } from '@/components/sidebar/state'
import { onMounted, ref } from 'vue'
import { apiBarber } from '../Services/BarberList/barberList'

export default {
  setup() {
    const { getBarber } = apiBarber()
    const liBarber = ref([])
    onMounted(async () => {
      liBarber.value = await getBarber()
      console.log(liBarber.value)
    })

    function Description(barber) {
      alert(barber.phone)
    }

    return { toggleSidebar, liBarber, Description }
  }
}
</script>

<style scoped lang="css">
.wrapper-list {
  list-style: none;
  padding: 2rem;
  background-color: #cd9f6e;
}
.wrapper-Barber {
  width: 30%;
  border-radius: 0.8rem;
  background-color: #9b6b37;
  padding: 0.3rem;
  margin-bottom: 1rem;
  cursor: pointer;
}
</style>
