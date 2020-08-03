<template>
    <div >

        <v-toolbar class="blue lighten-2">
            <v-toolbar-title>Cases</v-toolbar-title>
        </v-toolbar>

        <v-alert>All cases can be seen here.</v-alert>

        <v-row>
            <v-col cols="5">
                <v-text-field
                        v-model="search"
                        append-icon="mdi-magnify"
                        label="Enter Case ID/Type/Location"
                        solo

                        hide-details
                ></v-text-field>
            </v-col>
        </v-row>

        <v-data-table :headers="headers" :search="search" :items="covers" item-key="name">

            <template v-slot:item.caseDocumentPath="{ item }">
                <v-btn
                        class="blue"
                        dark
                        small
                        text
                        v-on:click="onDownloadClicked(item)"
                >Download</v-btn>
            </template>

            <template v-slot:item.documentConvertedText="{ item }">
                <v-btn
                        class="blue"
                        dark
                        small
                        text
                        v-on:click="onOCRClicked(item)"
                >Convert Document <br> To Text</v-btn>
            </template>

            <template v-slot:item.documentConvertedText="{ item }">
                <v-btn
                        class="blue"
                        dark
                        small
                        text
                        v-on:click="onOCRClicked(item)"
                >Convert Document <br> To Text</v-btn>

            </template>

            <template v-slot:item.addEvidence="{ item }">
                <v-btn
                        class="blue"
                        dark
                        small
                        text
                        v-on:click="onCaseClicked(item)"
                >Submit Evidence for this case</v-btn>

            </template>

        </v-data-table>



        <v-dialog v-model="showDialog" width="600px">
            <v-card>
                <v-card-title>
                    <span class="headline">Document to Text</span>
                </v-card-title>
                <v-card-text>{{ocrText}}</v-card-text>
                <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn color="blue darken-1" text @click="showDialog = false">OK</v-btn>
                </v-card-actions>
            </v-card>
        </v-dialog>
    </div>
</template>

<script>
    export default {
        name: 'ViewAllCase',
        methods:{

            onCaseClicked(item){

                this.$router.push({name:'AddEvidence',params:{caseVal:item}})
            },
            downloadFile(filename){
                console.log(filename)

                let request = {"fileName":filename};

                let loader = this.$loading.show({
                    container: this.$refs.formContainer,
                    canCancel: false,
                    onCancel: null,
                });

                //hit api call
                this.$api.post('/download/document', request)
                    .then((response) => {
                        loader.hide();
                        if (response.data.status === true){

                            this.showNotification("Success","File downloaded.");
                            window.open(response.data.data, '_blank');
                        }else {
                            this.showNotification("Error","Failed to download file.","info")
                        }

                    }, (error) => {

                        loader.hide();
                        console.log(error);
                        this.showNotification("Error","Failed to download file.","error")
                    });

            },

            onDownloadClicked(item){
                console.log(item);
                this.downloadFile(item.caseDocumentPath);

            },
            onOCRClicked(item){

                console.log(item);

                if (item.documentConvertedText !== ""){
                    this.showDialog = true;
                    this.ocrText = item.documentConvertedText;

                }else {

                    let request = {"fileName":item.caseDocumentPath};

                    let loader = this.$loading.show({
                        container: this.$refs.formContainer,
                        canCancel: false,
                        onCancel: null,
                    });
                    //hit api call
                    this.$api.post('/download/ocr', request)
                        .then((response) => {
                            loader.hide();
                            if (response.data.status === true){

                                this.showNotification("Success","Processed Document to Text.")
                                this.showDialog = true;
                                this.ocrText = response.data.data;
                            }else {
                                this.showNotification("Error","Failed to process document.","info")
                            }

                        }, (error) => {

                            loader.hide();
                            console.log(error);
                            this.showNotification("Error","Failed to process document..","error")
                        });
                }



            }
        },
        mounted() {
            let loader = this.$loading.show({
                container: this.$refs.formContainer,
                canCancel: false,
                onCancel: null,
            });

            this.$api.get('/case/all')
                .then((response) => {
                    loader.hide();
                    if (response.data.length > 0){
                        this.covers = response.data;
                        this.showNotification("Success","Fetched all cases.")
                    }else {
                        this.showNotification("Note","No cases available.","info")
                    }

                }, (error) => {
                    loader.hide();
                    console.log(error);
                    this.showNotification("Error","No cases available.","error")
                });
        },
        data() {
            return {
                showDialog:false,
                ocrText:"",
                search: '',
                covers: [],
                headers:[

                    {
                        text: ' Case ID/Number',
                        value: 'id',
                    },
                    {
                        text: 'Incident Number',
                        value: 'incidentNumber',
                    },

                    {
                        text: ' Case type',
                        value: 'caseType',
                    },
                    {
                        text: ' Action Date',
                        value: 'actionDate',
                    },
                    {
                        text: 'Case Officer',
                        value: 'caseOfficer',
                    },
                    {
                        text: ' Case Document',
                        value: 'caseDocumentPath',
                    },
                    {
                        text:'Case Document to Text',
                        value: 'documentConvertedText',
                    },
                    {
                        text:'Submit Evidence',
                        value: 'addEvidence',
                    }
                ],
            }
        },
    }
</script>
