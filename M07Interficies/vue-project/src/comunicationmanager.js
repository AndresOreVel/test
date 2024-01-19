export async function getResults(vueObject) {
    console.log(vueObject);
    const response = await fetch('https://randomuser.me/api/');
    const usuarios = await response.json();
    vueObject.results = usuarios.results;
}
export async function getFilters(vueObject,gender,pais){
    console.log(vueObject);
    const response = await fetch();
}