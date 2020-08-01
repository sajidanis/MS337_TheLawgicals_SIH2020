<template>
    <div>
        <AppBar />
        <SideBar :navItems="legalTeamNavItems" />
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
    name: 'LegalTeamIndex',
    components: {
        SideBar,
        AppBar,
        Footer,
    },
    data() {
        return {
            miniVariant: true,
            legalTeamNavItems: [
              {
                title: 'Verified Evidences',
                icon: '',
                route: { name: 'LegalTeamVerifiedEvidences' },
              },
              {
                title: 'Approved Evidences',
                icon: '',
                route: { name: 'ApprovedEvidencesLegalTeam' },
              },
              {
                title: 'Provide Certificate',
                icon: '',
                route: { name: 'AssignCertificates' },
              },
              {
                title: 'Back To Stakeholders Dashboard',
                icon: 'fa-home',
                route: '/dashboard',
              },
            ],
        }
    },
}
</script>

<style lang="scss" scoped></style>
