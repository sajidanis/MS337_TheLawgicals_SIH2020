<template>
    <div>
        <AppBar @toMiniVariant="changeMiniVariant" />
        <SideBar :navItems="dashboardNavItems" :miniVariant="miniVariant" />
        <v-main app>
            <v-container>
                <router-view></router-view>
            </v-container>
        </v-main>

        <Footer />
    </div>
</template>

<script>
import SideBar from '@/dashboard/layout/SideBar.vue'
import AppBar from '@/dashboard/layout/AppBar.vue'
import Footer from '@/dashboard/layout/Footer.vue'

export default {
    name: 'Dashboard',
    methods: {
        changeMiniVariant() {
            this.miniVariant = !this.miniVariant
        },
    },
    components: {
        SideBar,
        AppBar,
        Footer,
    },
    data() {
        return {
            miniVariant: false,
            dashboardNavItems: [
                {
                    title: 'Manager',
                    icon: '',
                    route: { name: 'ManagerIndex' },
                },

                {
                    title: 'Deponent ',
                    icon: ' ',
                    route: { name: 'DeponentIndex' },
                },
                {
                    title: 'Legal Team',
                    icon: '',
                    route: { name: 'LegalTeamIndex' },
                },
                {
                    title: 'Forensic Experts',
                    icon: ' ',
                    route: { name: 'ForensicExpertsIndex' },
                },
                {
                    title: 'Auditor',
                    icon: '',
                    route: { name: 'AuditorIndex' },
                }
            ],
        }
    },
}
</script>

<style lang="scss" scoped></style>

