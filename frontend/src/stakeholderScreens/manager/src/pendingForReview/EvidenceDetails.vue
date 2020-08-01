<template>
    <v-container>
        <v-card class="mx-auto mb-0 pb-0">
            <v-tabs background-color="blue" centered dark text>
                <v-tabs-slider></v-tabs-slider>

                <v-tab>Basic Details</v-tab>
                <v-tab>Cover Details</v-tab>

                <v-tab-item :key="tab1">
                    <v-card flat>
                        <v-div class="text-center">
                            <h1>Evidence Details</h1>
                        </v-div>
                        <br />
                        <br />

                        <v-container class="pl-16 ml-16">
                            <pre>Company Name                       :      AMC Networks PTE Limited<br />Company Registration Number        :      SG808332 <br />Company Contact Person             :      Rajesh Kumar <br />Company Contact Person Number      :      9865667521 <br />Tender Category                    :      Services <br />Main E-Mail Address                :      rajesh@amc.co.in <br />Telephone(Office)                  :      0116774755 <br />Mobile Number                      :      9867545723 <br />Main Company Address               :      F3/277, Mogli Building, Noida, UP
          
          </pre>
                        </v-container>

                        <br />
                        <br />
                        <br />
                    </v-card>
                </v-tab-item>

                <v-tab-item :key="tab2">
                    <v-card flat>
                        <br />
                        <br />
                        <pre class="text-center">
 Evidence Registration Number              :               GEUF353G</pre>
                        <br />
                        <br />
                        <v-container>
                            <v-data-table :headers="headers" :items="covers" item-key="name">
                                <template v-slot:item.ViewDoc="{ item }">
                                    <v-btn small v-model="item.ViewDoc" icon>
                                        <v-icon>fa-folder-open</v-icon>
                                    </v-btn>
                                </template>
                            </v-data-table>
                        </v-container>
                    </v-card>
                </v-tab-item>
            </v-tabs>
            <div class="text-center">
                <v-btn small to="EvidenceRegistered">Verify and Next</v-btn>
            </div>
        </v-card>
    </v-container>
</template>

<script>
export default {
    name: 'BidderDetail',

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
            ],
        }
    },
}
</script>
