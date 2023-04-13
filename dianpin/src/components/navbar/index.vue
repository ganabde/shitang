<script setup>
import {ref} from "vue";

defineProps({
  title: String,
  data: Array
})

</script>

<template>
  <div class="nav-container">
    <ul class="ul-list">
      <li class="list-item" v-for="item in data">
        <a :href="item.link" target="_blank">{{item.label}}</a>
        <ul class="drop-list" v-if="item.children">
          <li class="drop-list-item" v-for="child in item.children">
            <a :href="child.link" target="_blank">{{child.label}}</a>
          </li>
        </ul>
      </li>
    </ul>
  </div>
</template>


<style scoped>
.nav-container {
  margin: 0 auto;
  width: 80%;
  background: #FFFFFF00;
  height:40px;
}

.list-item {
  float: left;
  height: 40px;
  line-height: 40px;
  text-align: center;
  position: relative;
}

.list-item::before {
  display: block;
  width: 3px;
  height: 20px;
  background-color: #943939;
  content: '';
  float: left;
  position: relative;
  left: 10px;
  top: 10px;
}

.list-item a {
  display: block;
  color: #ffffff;
  padding: 0 20px;
}


.list-item a:hover {
  background: #943939;
}

.drop-list {
  background: #0c2260;
  display: none;
}

.list-item:hover .drop-list {
  display: block;
}

/*.drop-list-item:nth-child(1)::before {*/
/*  content: none;*/
/*}*/
/*.drop-list-item::before {*/
/*  content: '';*/
/*  display: block;*/
/*  margin: 0 auto;*/
/*  width: 80%;*/
/*  height: 1px;*/
/*  background-color: #666;*/
/*}*/
.drop-list-item a:hover{
  background: #943939;
}
</style>