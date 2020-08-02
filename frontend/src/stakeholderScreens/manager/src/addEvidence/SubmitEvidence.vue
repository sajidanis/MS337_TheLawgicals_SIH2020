<template>
    <v-div>
        <v-container app class="ml-8 pl-8">

        <v-toolbar class="blue lighten-2"> <v-toolbar-title> Add new Evidence</v-toolbar-title></v-toolbar>

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
              <h3 style="color:#0099FF" align="left">Associated Person</h3>
                <v-row>
                    <v-col cols="3">
                        <v-subheader>Associated Person</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-text-field outlined v-model="input.associatedPerson.name"></v-text-field>
                    </v-col>
                </v-row>

                <v-row>
                    <v-col cols="3">
                        <v-subheader>Address</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-text-field outlined v-model="input.associatedPerson.address"></v-text-field>
                    </v-col>
                </v-row>

                <v-row>
                    <v-col cols="3">
                        <v-subheader>Association</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-text-field outlined v-model="input.associatedPerson.association"></v-text-field>
                    </v-col>
                </v-row>
              <h3 style="color:#0099FF" align="left">Item Information</h3>
                <v-row>
                    <v-col cols="3">
                        <v-subheader>Item Information</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-textarea outlined v-model="input.itemInformation.details"></v-textarea>
                    </v-col>
                </v-row>

                <v-row>
                    <v-col cols="3">
                        <v-subheader>Recovery Location</v-subheader>
                    </v-col>
                    <v-col cols="3">
                      <v-text-field outlined v-model="input.itemInformation.recoveryLocation"></v-text-field>
                    </v-col>
                </v-row>

              <v-row>
                <v-col cols="3">
                  <v-subheader>Item Status</v-subheader>
                </v-col>
                <v-col cols="3">
                  <v-text-field outlined v-model="input.itemInformation.itemStatus"></v-text-field>
                </v-col>
              </v-row>

              <v-row>
                <v-col cols="3">
                  <v-subheader>Item Type</v-subheader>
                </v-col>
                <v-col cols="3">
                  <v-text-field outlined v-model="input.itemInformation.itemType"></v-text-field>
                </v-col>
              </v-row>
              <v-row>
                <v-col cols="3">
                  <v-subheader>Item Description</v-subheader>
                </v-col>
                <v-col cols="3">
                  <v-text-field outlined v-model="input.itemInformation.itemDescription"></v-text-field>
                </v-col>
              </v-row>
              <v-row>
                <v-col cols="3">
                  <v-subheader>Final Disposition</v-subheader>
                </v-col>
                <v-col cols="3">
                  <v-text-field outlined v-model="input.itemInformation.finalDisposition"></v-text-field>
                </v-col>
              </v-row>

                <br />
                <div class="text-center">
                    <v-btn class="primary" v-on:click="submitClicked()">Submit Evidence</v-btn>
                </div>
            </v-form>
        </v-container>
    </v-div>
</template>

<script>
export default {
    name: 'AddBidder',
    methods:{
        submitClicked(){

            let request = this.input;
            let loader = this.$loading.show({
                container: this.$refs.formContainer,
                canCancel: false,
                onCancel: null,
            });

            this.$api.post('/evidence/create',request)
                .then((response) => {
                    loader.hide();
                    if (response.data.id !== null){

                        this.showNotification("Success","Created evidence successfully.")
                        this.$router.push({ "name": 'SuspendedBidder' })
                    }else {
                        this.showNotification("Note","Failed to create evidence.","info")
                    }

                }, (error) => {
                    loader.hide();
                    console.log(error);
                    this.showNotification("Error","Failed to create evidence.","error")
                });

        }
    },
    mounted() {
        this.showNotification("Test","Test")
    },
    data() {
        return {
            input:{
                caseInformation:{
                    itemClass: "",
                    incidentNumber: "",
                    caseType: "",
                    actionDate: "",
                    caseOfficer: ""
                },
                associatedPerson:{
                    name: "",
                    address: "",
                    association: null
                },
                itemInformation:{
                    details: "",
                    recoveryLocation: "",
                    itemStatus: "",
                    itemType: "",
                    itemDescription: "",
                    finalDisposition: ""
                }

            },
          itemClass:['Digital Evidence', 'Evidence','Property','Evidence- NO cNET IR']
        }
    },
}
</script>
