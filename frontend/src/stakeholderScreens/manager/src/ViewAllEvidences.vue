<template>
    <div>
        <v-toolbar class="blue lighten-2">
            <v-toolbar-title>Evidences</v-toolbar-title>
        </v-toolbar>
        <v-alert>All evidences can be seen here.</v-alert>
        <v-container mx-auto>
            <v-data-table :headers="headers" :items="covers" item-key="name">
                <template v-slot:item.active="{ item }">
                    <v-checkbox small v-model="item.active"></v-checkbox>
                </template>
                <template v-slot:item.edit="{ item }">
                    <v-btn small v-model="item.edit" icon>
                        <v-icon>fa-pen</v-icon>
                    </v-btn>
                </template>
                <template v-slot:item.delete="{ item }">
                    <v-btn small v-model="item.delete" icon>
                        <v-icon>fa-times-circle</v-icon>
                    </v-btn>
                </template>
            </v-data-table>
        </v-container>
    </div>
</template>

<script>
export default {
    name: 'ViewAllEvidences',

    data() {
        return {
            covers: [
              {
                Barcode: 'EMS1-2000007',
                ItemClass: 'Evidence',
                Description: 'Apple MacBook Pro Laptop',
                Location: 'Officer\'s Custody',
                IncidentNumber: 'PDE20181200379',
                CaseOfficer:'Officer Demo',
                CaseType:'Theft',
                ItemType:'General',
                ItemStatus:''
              },
              {
                Barcode: 'EMS1-2000006',
                ItemClass: 'Evidence',
                Description: ' $2204',
                Location: 'Evidence High Value Vault',
                IncidentNumber: 'PDE20200400234',
                CaseOfficer:'Money',
                CaseType:'Death Investigation',
                ItemType:'General',
                ItemStatus:''
              },
              {
                Barcode: 'EMS1-2000005',
                ItemClass: 'Evidence',
                Description: ' Blood Sample from Broken Window',
                Location: 'Evidence High Value Vault',
                IncidentNumber: 'PDE20181200379',
                CaseOfficer:'Officer Demo',
                CaseType:'Theft',
                ItemType:'General',
                ItemStatus:''
              },
              {
                Barcode: 'EMS1-2000005',
                ItemClass: 'Evidence',
                Description: 'Crime Scene Photos',
                Location: 'Evidence Locker - 1BCG',
                IncidentNumber: 'PDE20181200379',
                CaseOfficer:'Officer Demo',
                CaseType:'Forgery',
                ItemType:'Money',
                ItemStatus:''
              },
              {
                Barcode: 'EMS1-2000004',
                ItemClass: 'Evidence',
                Description: 'Witness Statement, Jason Kid',
                Location: 'PDEVIDENCE Digital Storage',
                IncidentNumber: 'PD Evidence',
                CaseOfficer:'Theft',
                CaseType:'General',
                ItemType:'',
                ItemStatus:''
              },
            ],
            headers: [
              {
                text: 'Barcode',
                value: 'Barcode',
              },
              {
                text: 'ItemClass',
                value: 'ItemClass',
              },
              {
                text: 'Description',
                value: 'Description',
              },

              {
                text: 'Location',
                value: 'Location',
              },
              {
                text: ' Incident Number',
                value: 'IncidentNumber',
              },
              {
                text: 'Case Officer',
                value: 'CaseOfficer',
              },
              {
                text: ' Case type',
                value: 'CaseType',
              },
              {
                text: ' Item Type',
                value: 'ItemType',
              },
              {
                text: ' Item Status',
                value: 'ItemStatus',
              },
                {
                    text: 'Edit',
                    value: 'edit',
                },
                {
                    text: ' ',
                    value: 'delete',
                },
            ],
        }
    },
}
</script>
