<template>
    <v-container>
        <v-div class="mx-16">
            <v-card class="mx-16">
                <v-toolbar dark class="blue">
                    <v-toolbar-title>
                        Specific Evidence for cover:
                        EMS1-2000007
                    </v-toolbar-title>
                </v-toolbar>
                <v-alert text outlined color="blue">
                    Description about the evidence content . You
                    have entered 0 to 100 character
                </v-alert>
                <v-row>
                    <v-col cols="3">
                        <v-subheader>
                            Evidence Description
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col cols="4">
                        <v-textarea outlined></v-textarea>
                    </v-col>
                </v-row>

                <v-row>
                    <v-col cols="3">
                        <v-subheader>
                            Evidence type
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-select label=".pdf" outlined></v-select>
                    </v-col>
                </v-row>
            </v-card>
        </v-div>
        <br />
        <div class="text-right">
            <v-btn class="mr-4">Cancel</v-btn>
            <v-btn class="mr-16">Save</v-btn>
        </div>
        <br />
        <v-card class="mx-16 px-0">
            <v-toolbar dark class="blue">
                <v-toolbar-title>Cover details</v-toolbar-title>
            </v-toolbar>
            <v-data-table :headers="headers" :items="covers" item-key="name">
                <template v-slot:item.edit="{ item }">
                    <v-btn small v-model="item.edit" icon>
                        <v-icon>fa-pen</v-icon>
                    </v-btn>
                </template>
                <template v-slot:item.delete="{ item }">
                    <v-btn small v-model="item.delete" icon>
                        <v-icon>fa-trash</v-icon>
                    </v-btn>
                </template>
            </v-data-table>
        </v-card>
        <br />
        <div class="text-right mr-12 mb-12">
            <v-btn class="mr-4" @click.stop="dialog = true">Save evidence as Verified</v-btn>
            <v-btn>Submit</v-btn>
            <v-dialog v-model="dialog" max-width="410">
                <v-card>
                    <v-toolbar dark class="blue lighten-1 mb-8">
                        <v-toolbar-title>Save evidence as verified</v-toolbar-title>
                    </v-toolbar>
                    <v-col cols="8" class="text-center mx-auto">
                        <v-text-field outlined label="Tender Name" single-line />
                    </v-col>

                    <v-col cols="8" class="text-center mx-auto">
                        <v-select outlined label="Tender Type" single-line />
                    </v-col>
                    <br />
                    <v-btn flat class="mr-16 ml-8 mb-4">Cancel</v-btn>

                    <v-btn flat class="mr-4 mb-4 ml-16">Save</v-btn>
                </v-card>
            </v-dialog>
        </div>
        <br />
    </v-container>
</template>

<script>
export default {
    name: 'cover2',

    data() {
        return {
            dialog: false,
            covers: [
                {
                    label: '2012_NIC_16725-pack1',
                    type: '.pdf',
                    description: 'Scanned copy of tender fee and EMO',
                },
                {
                    label: '2012_NIC_16725-pack2',
                    type: '.pdf',
                    description: 'Technical bid as per Tender document',
                },
            ],
            headers: [
                {
                    text: 'Label',
                    value: 'label',
                },
                {
                    text: 'Type',
                    value: 'type',
                },
                {
                    text: 'Description',
                    value: 'description',
                },
                {
                    text: 'Edit',
                    value: 'edit',
                },
                {
                    text: 'Delete',
                    value: 'delete',
                },
            ],
        }
    },
}
</script>
