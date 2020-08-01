<template>
  <v-app class="login">
    <v-img src="@/assets/electronic-evidence.jpg">
      <v-card width="400" class="mx-auto mt-12">
        <v-toolbar>
          <v-toolbar-title class="pb-0">
            <h4>Member Login</h4>
          </v-toolbar-title>
        </v-toolbar>
        <v-card-text>
          <v-form @submit.prevent="login">
            <v-text-field
                label="Username"
                prepend-icon="fa-user"
                v-model="user"
                text--primary
                required
            />
            <v-text-field
                :type="showPassword ? 'text' : 'password'"
                label="Password"
                v-model="pwd"
                prepend-icon="fa-lock"
                :append-icon="showPassword ? 'fa-eye' : 'fa-eye-slash'"
                @click:append="showPassword = !showPassword"
                text--primary
                required
            />
          </v-form>
        </v-card-text>
        <v-divider></v-divider>
        <v-card-actions>
          <v-btn color="info" width="385" to="/dashboard">Login</v-btn>
        </v-card-actions>
      </v-card>
    </v-img>
  </v-app>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      showPassword: 'true',
      user: null,
      pwd: null,
    }
  },
  methods: {
    login() {
      console.log('username is ${this.user} and password is ${this.pwd}')
    },
  },
}
</script>

<style scoped>

</style>