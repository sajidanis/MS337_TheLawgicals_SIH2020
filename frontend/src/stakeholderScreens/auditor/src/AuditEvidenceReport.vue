<template>
  <v-container fluid>
    <v-row>
      <v-col cols="12">
        <v-row align="start" justify="center" class="grey lighten-5" style="height: 100px;">
          <v-card class="ma-3 pa-6" outlined tile>120 New Evidences</v-card>
          <v-card class="ma-3 pa-6" outlined tile>25 Inquiries</v-card>
          <v-card class="ma-3 pa-6" outlined tile>4 New Reports</v-card>
          <v-card class="ma-3 pa-6" outlined tile>175 Total Evidences</v-card>
        </v-row>
      </v-col>
    </v-row>

    <v-sparkline
        :labels="labels"
        :value="value"
        :gradient="gradient"
        padding="8"
        line-width="13"
        type="bar"
        auto-draw
        :show-labels="showLabels"
        label-size="5"
    ></v-sparkline>

    <v-divider></v-divider>

    <v-row>
      <v-col cols="12" md="4">
        <v-row class="fill-height" align="center">
          <v-item-group v-model="gradient" mandatory>
            <v-row>
              <v-item v-for="(gradient, i) in gradients" :key="i" :value="gradient">
                <v-card
                    :style="{
                    background:
                      gradient.length > 1
                        ? `linear-gradient(0deg, ${gradient})`
                        : gradient[0],
                  }"
                    width="10"
                    height="20"
                    class="mr-2"
                ></v-card>
              </v-item>
            </v-row>
          </v-item-group>
        </v-row>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
const gradients = [['red', 'orange', 'yellow']]

export default {
name: "AuditEvidenceReport",
  data() {
    return {
      alignmentsAvailable: [
        'start',
        'center',
        'end',
        'baseline',
        'stretch',
      ],
      alignment: 'center',
      dense: false,
      justifyAvailable: [
        'start',
        'center',
        'end',
        'space-around',
        'space-between',
      ],
      justify: 'center',

      gradient: gradients,
      value: [2, 5, 9, 5, 10, 3, 5, 14, 10, 1, 8, 2],

      gradients,

      labels: [
        '12am',
        '3am',
        '6am',
        '9am',
        '12pm',
        '3pm',
        '6pm',
        '9pm',
        '10pm',
        '11pm',
        '12am',
        '3am',
      ],
    }
  },
}
</script>

<style scoped>

</style>