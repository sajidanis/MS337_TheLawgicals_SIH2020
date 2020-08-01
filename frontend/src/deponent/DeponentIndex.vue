<template>
    <div>
        <AppBar />
        <SideBar :navItems="deponentNavItems"  />
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
    name: 'DeponentIndex',
    components: {
        SideBar,
        AppBar,
        Footer,
    },
    data() {
        return {
            miniVariant: true,
            deponentNavItems: [
              {
                title: 'Evidence Submissions',
                icon: '',
                route: { name: 'EvidenceSubmissions' },
              },
              {
                title: 'Submit New Evidence',
                icon: '',
                route: { name: 'SubmitNewEvidence' },
              },
              // {
              //   title: 'Evidence Verified',
              //   icon: '',
              //   route: { name: 'VerifyEvidence' },
              // },
              // {
              //   title: 'Evidence Admissible',
              //   icon: '',
              //   route: { name: 'EvidenceAdmissible' },
              // },
              // {
              //   title: 'Evidence Falsified',
              //   icon: '',
              //   route: { name: 'EvidenceFalsified' },
              // },
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
