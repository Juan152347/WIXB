<template>
  <ul class="wrapper-list">
    <li
      v-for="(barber, index) in BarberS"
      :key="index"
      @click="Description(barber)"
    >
      <div class="wrapper-Barber">
        <p>{{ barber.name }}</p>
      </div>
    </li>
  </ul>
  <div v-if="hayBarber">
    <BarberDetail :name="actualBarber.name" :phone="actualBarber.phone" />
  </div>
</template>

<script>
import { toggleSidebar } from '@/components/sidebar/state'
import { computed, ref } from 'vue'
import BarberDetail from '../components/Barber/BarberDetails.vue'
import { verBarberos } from '../Uses/barberlistUse'

export default {
  name: 'Barbers',
  components: {
    BarberDetail
  },
  setup() {
    const { retornarBarberos } = verBarberos()
    const actualBarber = ref(null)
    const { BarberS } = retornarBarberos()
    function Description(barber) {
      console.log(actualBarber)
      actualBarber.value = barber
    }

    const hayBarber = computed(() => {
      return actualBarber.value != null
    })

    return { toggleSidebar, BarberS, Description, actualBarber, hayBarber }
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
