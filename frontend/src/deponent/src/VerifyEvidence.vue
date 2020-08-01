<template>
    <v-container>
        <v-card class="mx-auto mb-0 pb-0">
            <v-tabs background-color="blue" centered dark text>
                <v-tabs-slider></v-tabs-slider>

                <v-tab>Basic Details</v-tab>
                <v-tab>Cover Details</v-tab>

                <v-tab-item :key="tab1">
                    <v-card flat>
                        <BasicDetails />
                    </v-card>
                </v-tab-item>

                <v-tab-item :key="tab2">
                    <v-card flat>
                        <CoverDetails />
                    </v-card>
                </v-tab-item>
            </v-tabs>
        </v-card>
    </v-container>
</template>

<script>
import BasicDetails from './BasicDetails.vue'
import CoverDetails from './cover/CoverDetails.vue'
export default {
    name: 'VerifyEvidence',
    components: {
        BasicDetails,
        CoverDetails,
    },
}
</script>
