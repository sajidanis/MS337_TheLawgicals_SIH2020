<template>
    <div>
        <v-container app class="ml-8 pl-8">

            <v-toolbar class="blue lighten-2"> <v-toolbar-title> Add new Case</v-toolbar-title></v-toolbar>

            <v-form class="mt-10">
                <h3 style="color:#0099FF" align="left">Case Information</h3>
                <v-row>
                    <v-col cols="3">
                        <v-subheader>Item Class</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-select :items="itemClass" outlined v-model="input.caseInformation.itemClass"></v-select>
                    </v-col>
                </v-row>

                <v-row>
                    <v-col cols="3">
                        <v-subheader>Incident Number</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-text-field outlined v-model="input.caseInformation.incidentNumber"></v-text-field>
                    </v-col>
                </v-row>

                <v-row>
                    <v-col cols="3">
                        <v-subheader>Case Type</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-text-field outlined v-model="input.caseInformation.caseType" ></v-text-field>
                    </v-col>
                </v-row>

                <v-row>
                    <v-col cols="3">
                        <v-subheader>Next Action Date</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-text-field outlined v-model="input.caseInformation.actionDate"></v-text-field>
                    </v-col>
                </v-row>

                <v-row>
                    <v-col cols="3">
                        <v-subheader>Case Officer</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-text-field outlined v-model="input.caseInformation.caseOfficer"></v-text-field>
                    </v-col>
                </v-row>

                <br />
                <v-row >
                    <v-col cols="5">
                        <h4>Select File for Case</h4>
                        <v-file-input justify="left" ref="inputUpload" v-model="file"  v-on:change="handleFileUpload()" dense></v-file-input>
                    </v-col>

                </v-row>
                <div class="text-center">

                    <v-btn class="primary" v-on:click="submitClicked()">Submit Case</v-btn>
                </div>
            </v-form>
        </v-container>
    </div>
</template>

<script>
    export default {
        name: 'CreateCase',
        methods:{
            handleFileUpload(){

                console.log("this.file")
                console.log(this.file)
            },
            submitClicked(){


                let loader = this.$loading.show({
                    container: this.$refs.formContainer,
                    canCancel: false,
                    onCancel: null,
                });

                let formData = new FormData();
                formData.append('document', this.file);
                formData.append("case",JSON.stringify( this.input.caseInformation));

                this.$api.post('/case/create',formData,{
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                })
                    .then((response) => {
                        loader.hide();
                        if (response.data.id !== null){

                            this.showNotification("Success","Created case successfully.")
                            this.$router.push({ "name": 'ViewAllCase' })
                        }else {
                            this.showNotification("Note","Failed to create case.","info")
                        }

                    }, (error) => {
                        loader.hide();
                        console.log(error);
                        this.showNotification("Error","Failed to create case.","error")
                    });

            }
        },
        mounted() {
            this.showNotification("Test","Test")
        },
        data() {
            return {
                file:null,
                input:{
                    caseInformation:{
                        itemClass: "",
                        incidentNumber: "",
                        caseType: "",
                        actionDate: "",
                        caseOfficer: ""
                    }

                },
                itemClass:['Digital Evidence', 'Evidence','Property','Evidence- NO cNET IR']
            }
        },
    }
</script>
