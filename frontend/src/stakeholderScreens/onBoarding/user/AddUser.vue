<template>
    <div>
        <v-container app>
            <v-form>
                <h1>Add New User</h1>
                <v-row>
                    <v-col cols="3">
                        <v-subheader>User Name</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-text-field outlined></v-text-field>
                    </v-col>
                </v-row>

                <v-row>
                    <v-col cols="3">
                        <v-subheader>Password</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-text-field outlined></v-text-field>
                    </v-col>
                </v-row>

                <v-row>
                    <v-col cols="3">
                        <v-subheader>First Name</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-text-field outlined></v-text-field>
                    </v-col>
                </v-row>

                <v-row>
                    <v-col cols="3">
                        <v-subheader>Last Name</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-text-field outlined></v-text-field>
                    </v-col>
                </v-row>

                <v-row>
                    <v-col cols="3">
                        <v-subheader>Email</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-text-field outlined></v-text-field>
                    </v-col>
                </v-row>

                <v-row>
                    <v-col cols="3">
                        <v-subheader>Contact Primary</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-text-field outlined></v-text-field>
                    </v-col>
                </v-row>

                <v-row>
                    <v-col cols="3">
                        <v-subheader>Contact Secondary</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-text-field outlined></v-text-field>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="3">
                        <v-subheader>User Role</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-select label="Service" outlined></v-select>
                    </v-col>
                </v-row>

                <v-row>
                    <v-col cols="3">
                        <v-subheader>User Status</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-select label="Service" outlined></v-select>
                    </v-col>
                </v-row>
                <br />
                <div class="text-center">
                    <v-btn class="primary" to="viewall">Add User</v-btn>
                </div>
            </v-form>
        </v-container>
    </div>
</template>

<script>
export default {
    name: 'AddUser',
}
</script>

<style lang="scss" scoped></style>
