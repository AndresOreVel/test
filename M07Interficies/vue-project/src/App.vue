<script>
export default {
  data() {
    return {
      info: false,
      json: [],
      num : "",
      gender: "",
      nat: "",
    };
  },
  methods: {
    recuperarUsuario() {
      fetch('https://randomuser.me/api/', {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json',
        },
      })
        .then(response => response.json())
        .then((data) => {
          console.log("CONTENIDO", data.results);
          this.json = data.results;
        })
        .catch((error) => {
          console.log("Error: ", error);
        });
    },

    recuperaraFiltro(num, gender, nat) {
      fetch('https://randomuser.me/api/?results=' + num + '&gender=' + gender + '&nat=' + nat, {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json',
        },
      })
        .then(response => response.json())
        .then((data) => {
          console.log("CONTENIDO", data.results);
          this.json = data.results;
        })
        .catch((error) => {
          console.log("Error: ", error);
        });
    },
  },
  created() {
    console.log("CREADO");
  }
};
</script>

<template>
  <button class="button" @click="recuperarUsuario()">Recuperar 1 usuari</button><br>
  <button @click="recuperaraFiltro(this.num,this.gender,this.nat)">Recuperar usuaris amb filtre</button>

  <br>

  <input type="radio" value="male" v-model="gender"> Home
  <input type="radio" value="female" v-model="gender"> Dona
  <br>
  <input type="radio" value="EN" v-model="nat"> Espaya
  <input type="radio" value="US" v-model="nat"> EEUU

  <p>Quantitat d'usuaris <input placeholder="Cantidad" v-model="num"></p>

  <br>
  <div v-for="jsonDatos in json">
    <img class="Imagen" :src="jsonDatos.picture.thumbnail">
    <p>{{ jsonDatos.name.first }}</p>
  </div>
</template>

<style scoped>
.button {
  all: unset;
  display: flex;
  align-items: center;
  position: relative;
  padding: 0.6em 2em;
  border: mediumspringgreen solid 0.15em;
  border-radius: 0.25em;
  color: mediumspringgreen;
  font-size: 1.5em;
  font-weight: 600;
  cursor: pointer;
  overflow: hidden;
  transition: border 300ms, color 300ms;
  user-select: none;
}
</style>
