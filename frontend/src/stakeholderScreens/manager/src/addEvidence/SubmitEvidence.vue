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
                    <v-select :items="itemClass" outlined></v-select>
                  </v-col>
                </v-row>

                <v-row>
                    <v-col cols="3">
                        <v-subheader>Incident Number</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-text-field outlined></v-text-field>
                    </v-col>
                </v-row>

                <v-row>
                    <v-col cols="3">
                        <v-subheader>Case Type</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-text-field outlined></v-text-field>
                    </v-col>
                </v-row>

                <v-row>
                    <v-col cols="3">
                        <v-subheader>Next Action Date</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-text-field outlined></v-text-field>
                    </v-col>
                </v-row>

                <v-row>
                    <v-col cols="3">
                        <v-subheader>Case Officer</v-subheader>
                    </v-col>
                    <v-col cols="3">
                       <v-text-field outlined></v-text-field>
                    </v-col>
                </v-row>
              <h3 style="color:#0099FF" align="left">Associated Person</h3>
                <v-row>
                    <v-col cols="3">
                        <v-subheader>Associated Person</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-text-field outlined></v-text-field>
                    </v-col>
                </v-row>

                <v-row>
                    <v-col cols="3">
                        <v-subheader>Address</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-text-field outlined></v-text-field>
                    </v-col>
                </v-row>

                <v-row>
                    <v-col cols="3">
                        <v-subheader>Association</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-text-field outlined></v-text-field>
                    </v-col>
                </v-row>
              <h3 style="color:#0099FF" align="left">Item Information</h3>
                <v-row>
                    <v-col cols="3">
                        <v-subheader>Item Information</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-textarea outlined></v-textarea>
                    </v-col>
                </v-row>

                <v-row>
                    <v-col cols="3">
                        <v-subheader>Recovery Location</v-subheader>
                    </v-col>
                    <v-col cols="3">
                      <v-text-field outlined></v-text-field>
                    </v-col>
                </v-row>

              <v-row>
                <v-col cols="3">
                  <v-subheader>Item Status</v-subheader>
                </v-col>
                <v-col cols="3">
                  <v-text-field outlined></v-text-field>
                </v-col>
              </v-row>

              <v-row>
                <v-col cols="3">
                  <v-subheader>Item Type</v-subheader>
                </v-col>
                <v-col cols="3">
                  <v-text-field outlined></v-text-field>
                </v-col>
              </v-row>
              <v-row>
                <v-col cols="3">
                  <v-subheader>Item Description</v-subheader>
                </v-col>
                <v-col cols="3">
                  <v-text-field outlined></v-text-field>
                </v-col>
              </v-row>
              <v-row>
                <v-col cols="3">
                  <v-subheader>Final Disposition</v-subheader>
                </v-col>
                <v-col cols="3">
                  <v-text-field outlined></v-text-field>
                </v-col>
              </v-row>

                <br />
                <div class="text-center">
                    <v-btn class="primary" to="BidderAdded">Submit Evidence</v-btn>
                </div>
            </v-form>
        </v-container>
    </v-div>
</template>

<script>
export default {
    name: 'AddBidder',
    data() {
        return {
          itemClass:['Digital Evidence', 'Evidence','Property','Evidence- NO cNET IR']
        }
    },
}
</script>
