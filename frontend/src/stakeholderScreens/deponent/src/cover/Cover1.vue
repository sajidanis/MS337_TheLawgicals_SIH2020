<template>
    <v-app>
        <v-card color="blue" class="mx-auto" max-width="600" outlined>
            <v-card-title class="justify-center">Evidence Details</v-card-title>
            <v-data-table :headers="headers" :items="cover">
                <template v-slot:item.adddoc="{ item }">
                    <v-btn icon>
                        <v-icon v-model="item.glutenfree">fa-folder-open</v-icon>
                    </v-btn>
                </template>
            </v-data-table>
        </v-card>
    </v-app>
</template>

<script>
export default {
    name: 'cover1',

    data() {
        return {
            step: '1',
            headers: [
                {
                    text: 'S.No.',
                    value: 'sno',
                },
                { text: 'Case Name', value: 'name' },
                { text: 'Case Type', value: 'type' },
                { text: 'Case Document', value: 'doc' },
                { text: 'Add Document', value: 'adddoc' },
            ],
            cover: [
                {
                    sno: 1,
                    name: '2012_NIC_16725_pack1',
                    type: 'Evidence id',
                    doc: 0,
                },
                {
                    sno: 2,
                    name: '2012_NIC_16725_pack2',
                    type: 'Evidence Docs id',
                    doc: 0,
                },
            ],
        }
    },
}
</script>

<style>
.v-card__title {
    font-style: bold;
    color: antiquewhite;
}
</style>
