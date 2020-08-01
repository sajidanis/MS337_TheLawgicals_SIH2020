<template>
    <v-div>
        <v-container class="ml-8 pl-8">
            <v-breadcrumbs :items="items"></v-breadcrumbs>
            <v-form>
                <v-row>
                    <v-col cols="3">
                        <v-subheader>
                            Evidence Number
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-text-field outlined></v-text-field>
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
                        <v-select label="-select-" outlined></v-select>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="3">
                        <v-subheader>
                            Case Type
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-select label="-select-" outlined></v-select>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="3">
                        <v-subheader>
                          Association
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-select label="-select-" outlined></v-select>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="3">
                        <v-subheader>
                          Item Status
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-select label="-select-" outlined></v-select>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="3">
                        <v-subheader>
                          Case Officer
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-select label="-select-" outlined></v-select>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="3">
                        <v-subheader>
                            No. of Evidences
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-select label="-select-" outlined></v-select>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="3">
                        <v-subheader>
                            Should allow reverification
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-container fluid>
                            <v-radio-group :mandatory="true">
                                <v-radio label="Yes" value="radio-1"></v-radio>
                                <v-radio label="No" value="radio-2"></v-radio>
                            </v-radio-group>
                        </v-container>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="3">
                        <v-subheader>Should allow Withdrawal of Evidence</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-container fluid>
                            <v-radio-group>
                                <v-radio label="Yes" value="radio-1"></v-radio>
                                <v-radio label="No" value="radio-2"></v-radio>
                            </v-radio-group>
                        </v-container>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="3">
                        <v-subheader>Should allow Withdrawal of Evidence</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-container fluid>
                            <v-radio-group>
                                <v-radio label="Yes" value="radio-1"></v-radio>
                                <v-radio label="No" value="radio-2"></v-radio>
                            </v-radio-group>
                        </v-container>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="3">
                        <v-subheader>Should allow offline evidence Submission</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-container fluid>
                            <v-radio-group>
                                <v-radio label="Yes" value="radio-1"></v-radio>
                                <v-radio label="No" value="radio-2"></v-radio>
                            </v-radio-group>
                        </v-container>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="3">
                        <v-subheader>Should allow Evidence Verification and Inquiry</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-container fluid>
                            <v-radio-group>
                                <v-radio label="Yes" value="radio-1"></v-radio>
                                <v-radio label="No" value="radio-2"></v-radio>
                            </v-radio-group>
                        </v-container>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="3">
                        <v-subheader>Should allow Withdrawal of Evidence</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-radio-group>
                            <v-radio label="Yes" value="radio-1"></v-radio>
                            <v-radio label="No" value="radio-2"></v-radio>
                        </v-radio-group>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="3">
                        <v-subheader>Should allow hard-copy</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-checkbox label="yes"></v-checkbox>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="3">
                        <v-subheader>Payment mode:</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-checkbox label="online"></v-checkbox>
                        <v-checkbox label="offline"></v-checkbox>
                    </v-col>
                </v-row>
                <v-data-table
                    :headers="headers"
                    :items="offins"
                    item-key="name"
                    item-keyy="yes"
                    class="elevation-1"
                >
                    <template v-slot:item.yes="{ item }">
                        <v-simple-checkbox v-model="item.yes"></v-simple-checkbox>
                    </template>
                </v-data-table>
                <br />
                <div class="text-right">
                    <v-btn>Cancel</v-btn>
                    <v-btn>Next</v-btn>
                </div>
            </v-form>
        </v-container>
    </v-div>
</template>

<script>
export default {
    name: 'BasicDetails',
    data() {
        return {
            items: [
                {
                    text: 'Verify Evidence',
                    disabled: false,
                    href: '',
                },
                {
                    text: 'Evidence Details',
                    disabled: true,
                    href: '',
                },
            ],

            tabitems: [
                {
                    tab: 'Evidence Details',
                },
                { tab: 'Cover Details' },
            ],
            headers: [
                {
                    text: 'Offline Instruction*',
                    align: 'left',
                    sortable: false,
                    value: 'name',
                },
                {
                    text: ' ',
                    value: 'yes',
                },
            ],
            offins: [
                {
                    yes: false,
                    name: 'SS- small saving instruction',
                },
                {
                    name: 'Bank cheque',
                    yes: false,
                },
                {
                    name: 'DD- Demand Draft',
                    yes: false,
                },
                {
                    name: 'BG- Bank Guarantee',
                    yes: false,
                },
            ],
        }
    },
}
</script>
