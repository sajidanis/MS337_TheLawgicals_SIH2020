<template>
    <div>
        <AppBar  />
        <SideBar :navItems="forensicExpertNavItems" />
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
    name: 'ForensicExpertsIndex',
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
            forensicExpertNavItems: [
              {
                title: 'Evidence Report Findings',
                icon: '',
                route: { name: 'EvidenceReportFindings' },
              },
              {
                title: 'Approved Evidences',
                icon: '',
                route: { name: 'ApprovedEvidencesForensicExperts' }
              },
              {
                title: 'Testified Evidences',
                icon: '',
                route: { name: 'TestifiedEvidences' },
              },
              {
                title: 'Rejected Evidences',
                icon: '',
                route: { name: 'RejectedEvidences' },
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
