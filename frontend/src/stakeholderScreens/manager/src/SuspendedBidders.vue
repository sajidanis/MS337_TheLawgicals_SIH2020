<template>
    <v-container app>
        <div>
            <v-toolbar class="blue lighten-2">
                <v-toolbar-title>Evidences</v-toolbar-title>
            </v-toolbar>
            <v-alert>All evidences status can be seen here.</v-alert>
            <v-container mx-auto>
                <v-data-table :headers="headers" :items="covers" item-key="name"></v-data-table>
            </v-container>
        </div>
    </v-container>
</template>

<script>
export default {
    name: 'ViewAll',
    mounted() {
        let loader = this.$loading.show({
            container: this.$refs.formContainer,
            canCancel: false,
            onCancel: null,
        });

        this.$api.get('/evidence/all')
            .then((response) => {
                loader.hide();
                if (response.data.length > 0){
                    this.covers = response.data;
                    this.showNotification("Success","Fetched all evidences.")
                }else {
                    this.showNotification("Note","No evidences available.","info")
                }

            }, (error) => {
                loader.hide();
                console.log(error);
                this.showNotification("Error","No evidences available.","error")
            });
    },
    data() {
        return {
            covers: [

            ],
            headers: [
                {
                    text: 'Barcode',
                    value: 'Barcode',
                },
                {
                    text: 'ItemClass',
                    value: 'caseInformation.itemClass',
                },
                {
                    text: 'Description',
                    value: 'Description',
                },

                {
                    text: 'Location',
                    value: 'associatedPerson.address',
                },
                {
                    text: ' Incident Number',
                    value: 'id',
                },
              {
                text: 'Case Officer',
                value: 'caseInformation.aseOfficer',
              },
              {
                text: ' Case type',
                value: 'caseInformation.caseType',
              },
              {
                text: ' Item Type',
                value: 'itemInformation.itemType',
              },
              {
                text: ' Item Status',
                value: 'itemInformation.itemStatus',
              },
            ],
        }
    },
}
</script>