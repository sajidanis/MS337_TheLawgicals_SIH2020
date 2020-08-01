<template>
    <v-app>
        <v-card>
            <v-breadcrumbs :items="items"></v-breadcrumbs>

            <v-card>
                <v-window v-model="step">
                    <v-window-item :value="1">
                        <cover1 />
                        <v-spacer />
                        <div class="text-right mr-12 mb-12">
                            <v-btn @click="step++">Next</v-btn>
                        </div>
                    </v-window-item>
                    <v-window-item :value="2">
                        <cover2 />
                    </v-window-item>
                    <v-divider></v-divider>
                </v-window>
            </v-card>
        </v-card>
    </v-app>
</template>

<script>
import cover1 from './Cover1'
import cover2 from './Cover2'
export default {
    name: 'CoverDetails',
    components: {
        cover1,
        cover2,
    },
    data() {
        return {
            step: 1,
            items: [
                {
                    text: 'Verify Evidence',
                    disabled: false,
                    href: 'verifyEvidence',
                },
                {
                    text: 'Cover Details',
                    disabled: true,
                    href: '',
                },
            ],
        }
    },
}
</script>
