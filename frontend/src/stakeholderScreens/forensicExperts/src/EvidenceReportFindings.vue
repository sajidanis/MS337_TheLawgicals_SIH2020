<template>
  <v-div>
    <v-container app class="ml-8 pl-8">

      <v-toolbar class="blue lighten-2"> <v-toolbar-title> Submit Report</v-toolbar-title></v-toolbar>

      <v-form class="mt-10">
        <h3 style="color:#0099FF" align="left">Item</h3>
        <v-row>
          <v-col cols="3">
            <v-subheader>Active Items Only</v-subheader>
          </v-col>
          <v-col cols="3">
            <v-checkbox></v-checkbox>
          </v-col>
        </v-row>

        <v-row>
          <v-col cols="3">
            <v-subheader>Item Class</v-subheader>
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
            <v-subheader>Location</v-subheader>
          </v-col>
          <v-col cols="3">
            <v-text-field outlined></v-text-field>
          </v-col>
        </v-row>
        <v-row>
          <v-col cols="3">
            <v-subheader>Date Entered</v-subheader>
          </v-col>
          <v-col cols="3">
            <v-text-field outlined></v-text-field>
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
            <v-subheader>Recovery Date/Time</v-subheader>
          </v-col>
          <v-col cols="3">
            <v-text-field outlined></v-text-field>
          </v-col>
        </v-row>
        <v-row>
          <v-col cols="3">
            <v-subheader>Last Modified</v-subheader>
          </v-col>
          <v-col cols="3">
            <v-text-field outlined></v-text-field>
          </v-col>
        </v-row>
        <h3 style="color:#0099FF" align="left">Transaction</h3>
        <v-row>
          <v-col cols="3">
            <v-subheader>Transaction Type</v-subheader>
          </v-col>
          <v-col cols="3">
            <v-text-field outlined></v-text-field>
          </v-col>
        </v-row>

        <v-row>
          <v-col cols="3">
            <v-subheader>Must Have Signature</v-subheader>
          </v-col>
          <v-col cols="3">
            <v-checkbox></v-checkbox>
          </v-col>
        </v-row>
        <v-row>
          <v-col cols="3">
            <v-subheader>Must Have ID Scan</v-subheader>
          </v-col>
          <v-col cols="3">
            <v-checkbox></v-checkbox>
          </v-col>
        </v-row>
        <v-row>
          <v-col cols="3">
            <v-subheader>Performed By</v-subheader>
          </v-col>
          <v-col cols="3">
            <v-text-field outlined></v-text-field>
          </v-col>
        </v-row>

        <v-row>
          <v-col cols="3">
            <v-subheader>Transaction Date</v-subheader>
          </v-col>
          <v-col cols="3">
            <v-text-field outlined></v-text-field>
          </v-col>
        </v-row>

        <h3 style="color:#0099FF" align="left">Case</h3>
        <v-row>
          <v-col cols="3">
            <v-subheader>Case Type
            </v-subheader>
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
        <v-row>
          <v-col cols="3">
            <v-subheader>Incident Number</v-subheader>
          </v-col>
          <v-col cols="3">
            <v-text-field outlined></v-text-field>
          </v-col>
        </v-row>

        <br />
        <div class="text-center">
          <v-btn class="primary" to="BidderAdded">Submit Report</v-btn>
        </div>
      </v-form>
    </v-container>
  </v-div>
</template>

<script>
export default {
  name: "EvidenceReportFindings",

}
</script>

<style scoped>

</style>